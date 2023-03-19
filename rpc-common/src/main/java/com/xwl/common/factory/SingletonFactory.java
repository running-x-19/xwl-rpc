package com.xwl.common.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: xwl
 * @Date: 2023-03-18 19:30:46
 * @Desc: todo 单列设计模式 ConturrenthashMap
 */


public class SingletonFactory {

    /**
     * 保证线程安全
     */
    private static final Map<String, Object> OBJECT_MAP = new ConcurrentHashMap<>();

    public SingletonFactory() {

    }

    /**
     * 泛型方法
     * todo Class 创建 泛型方法
     *
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T getInstance(Class<T> c) {

        if (c == null) {
            throw new IllegalArgumentException();
        }

        String key = c.toString();
        if (OBJECT_MAP.containsKey(key)) {
            return c.cast(OBJECT_MAP.get(key));
        } else {
            return c.cast(OBJECT_MAP.computeIfAbsent(key, k -> {
                try {
                    return c.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException |
                        NoSuchMethodException | InvocationTargetException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }));
        }
    }

}
