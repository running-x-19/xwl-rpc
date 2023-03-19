package com.xwl.common.util.threadpool;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author: xwl
 * @Date: 2023-03-18 21:34:05
 * @Desc: 默认线程池配置
 */


@Slf4j
@Getter
@Setter
public class CustomThreadPoolConfig {

    /**
     * 线程池默认参数
     */
    private static final int DEFAULT_CORE_POOL_SIZE = 10;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE_SIZE = 100;
    private static final int DEFAULT_KEEP_ALIVE_TIME = 1;
    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MINUTES;

    private static final int DEFAULT_BLOCKING_QUEUE_CAPACITY = 100;
    private static final int BLOCKING_QUEUE_CAPACITY = 100;

    /**
     * 可配置参数
     */
    private int corePoolSize = DEFAULT_CORE_POOL_SIZE;
    private int maximumPoolSize = DEFAULT_MAXIMUM_POOL_SIZE_SIZE;
    private long keepAliveTime = DEFAULT_KEEP_ALIVE_TIME;
    private TimeUnit unit = DEFAULT_TIME_UNIT;

    /**
     * todo Runnable
     * 使用有界队列
     *
     * ArrayBlockingQueue	一个由数组结构组成的有界阻塞队列。
     * LinkedBlockingQueue	一个由链表结构组成的有界阻塞队列。
     * SynchronousQueue	一个不存储元素的阻塞队列，即直接提交给线程不保持它们。
     * PriorityBlockingQueue	一个支持优先级排序的无界阻塞队列。
     * DelayQueue	一个使用优先级队列实现的无界阻塞队列，只有在延迟期满时才能从中提取元素。
     * LinkedTransferQueue	一个由链表结构组成的无界阻塞队列。与SynchronousQueue类似，还含有非阻塞方法。
     * LinkedBlockingDeque	一个由链表结构组成的双向阻塞队列。
     *
     * 2、顺便说下线程池的执行规则如下：
     *
     * （1）当线程数小于核心线程数时，创建线程。
     *
     * （2）当线程数大于等于核心线程数，且任务队列未满时，将任务放入任务队列。
     *
     * （3）当线程数大于等于核心线程数，且任务队列已满：
     *
     * 若线程数小于最大线程数，创建线程。
     *
     * 若线程数等于最大线程数，抛出异常，拒绝任务。
     *
     * AbortPolicy	拒绝并抛出异常。
     * CallerRunsPolicy	重试提交当前的任务，即再次调用运行该任务的execute()方法。
     * DiscardOldestPolicy	抛弃队列头部（最旧）的一个任务，并执行当前任务。
     * DiscardPolicy	抛弃当前任务。
     *
     */
    private BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(BLOCKING_QUEUE_CAPACITY);
}
