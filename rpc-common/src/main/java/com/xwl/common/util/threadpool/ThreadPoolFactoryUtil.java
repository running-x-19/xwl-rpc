package com.xwl.common.util.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author: xwl
 * @Date: 2023-03-19 09:35:48
 * @Desc: 线程池制造工程
 */


@Slf4j
public class ThreadPoolFactoryUtil {

    /**
     * todo ExecutorService extend Executor
     */
    private static final ConcurrentHashMap<String, ExecutorService> THREAD_POOL
            = new ConcurrentHashMap();

    public ThreadPoolFactoryUtil() {

    }


    /**
     * 不带配置信息
     * 不带守护线程的thread
     *
     * @param threadPrefix
     * @return
     */
    public static ExecutorService createCustomThreadPoolIfAbsent(String threadPrefix) {
        CustomThreadPoolConfig customThreadPoolConfig = new CustomThreadPoolConfig();
        return createCustomThreadPoolIfAbsent(customThreadPoolConfig, threadPrefix, false);
    }


    /**
     * create 默认的线程池如果不存在的话
     * 不带守护线程的thread
     *
     * @param threadPrefix
     * @param poolConfig
     * @return
     */
    public static ExecutorService createCustomThreadPoolIfAbsent(String threadPrefix,
                                                                 CustomThreadPoolConfig poolConfig) {

        return createCustomThreadPoolIfAbsent(poolConfig, threadPrefix, false);
    }


    /**
     *
     * @param poolConfig 线程池配置
     * @param threadNameFix 线程前缀 - 区分不同业务的线程
     * @param daemon 是否是守护thread
     * @return
     */
    public static ExecutorService createCustomThreadPoolIfAbsent(CustomThreadPoolConfig poolConfig,
                                                                 String threadNameFix,
                                                                 Boolean daemon) {
        // 1.如果不存在这方面的线程业务 - 创建
        ExecutorService threadPool = THREAD_POOL.computeIfAbsent(threadNameFix, v -> {
            return createThreadPool(poolConfig, threadNameFix, daemon);
        });

        // 2.threadPool isShutDown or terminate
        if (threadPool.isShutdown() || threadPool.isTerminated()) {
            THREAD_POOL.remove(threadNameFix);
            threadPool = createThreadPool(poolConfig, threadNameFix, daemon);
            THREAD_POOL.put(threadNameFix, threadPool);
        }

        return threadPool;
    }


    /**
     * shutDown 所有的线程池
     * <p>
     * todo ExecutorService
     */
    public static void shutDownAllThreadPool() {
        log.info("use shutDownAllThreadPool method");
        THREAD_POOL.entrySet().parallelStream().forEach(entry -> {
            ExecutorService value = entry.getValue();
            value.shutdown();
            // 打印线程阻断信息
            log.info("shut down thread pool [{}] [{}]", entry.getKey(), value.isTerminated());

            // 等待阻断
            try {
                value.awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                log.error("Thread pool never Terminate");
                value.shutdown();
            }
        });
    }


    /**
     * 创建线程池
     * Executor -> ExecutorService -> ThreadPoolExecutor
     *
     * @param poolConfig
     * @return
     */
    private static ExecutorService createThreadPool(CustomThreadPoolConfig poolConfig,
                                                    String threadNamePrefix,
                                                    Boolean daemon
    ) {

        // 1.线程工厂
        ThreadFactory threadFactory = createThreadFactory(threadNamePrefix, daemon);

        // 2.创建线程
        return new ThreadPoolExecutor(
                poolConfig.getCorePoolSize(),
                poolConfig.getMaximumPoolSize(),
                poolConfig.getKeepAliveTime(),
                poolConfig.getUnit(),
                poolConfig.getWorkQueue(),
                threadFactory
        );
    }


    /**
     * 线程池工厂 判断一开始是否存在业务线程
     *
     * @param threadNamePrefix - 区分不同的业务, 创建线程的前缀
     * @param daemon           - 守护线程 当主线程执行完后, 会自动停止
     * @return
     */
    public static ThreadFactory createThreadFactory(String threadNamePrefix, Boolean daemon) {
        // 守护线程
        if (threadNamePrefix != null) {
            if (daemon != null) {
                // 建造者模式
                return new ThreadFactoryBuilder()
                        .setNameFormat(threadNamePrefix + "-%d")
                        .setDaemon(daemon)
                        .build();
            } else {
                return new ThreadFactoryBuilder()
                        .setNameFormat(threadNamePrefix + "-%d")
                        .build();
            }
        }
        // 创建默认线程工厂
        return Executors.defaultThreadFactory();
    }

    /**
     * 打印线程信息
     *
     * @param threadPoolExecutor
     */
    public static void printThreadFactoryInfo(ThreadPoolExecutor threadPoolExecutor) {

        // todo 定时任务线程工厂 API 什么意思
        ScheduledThreadPoolExecutor poolExecutor
                = new ScheduledThreadPoolExecutor(1, createThreadFactory("print-thread-status", false));

        poolExecutor.scheduleAtFixedRate(() -> {
            log.info("===============ThreadPool Status=============");
            log.info("ThreadPool Size [{}]", poolExecutor.getPoolSize());
            log.info("Active Threads [{}]", poolExecutor.getActiveCount());
            log.info("Number of Tasks [{}]", poolExecutor.getCompletedTaskCount());
            log.info("Number of  Tasks in Queue [{}]", poolExecutor.getQueue().size());
        }, 0, 1, TimeUnit.SECONDS);
    }
}
