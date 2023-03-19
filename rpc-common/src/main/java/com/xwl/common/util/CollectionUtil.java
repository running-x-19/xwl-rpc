package com.xwl.common.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

/**
 * @Author: xwl
 * @Date: 2023-03-18 21:08:14
 * @Desc: 集合工具类
 */

public class CollectionUtil {

    /**
     * Collection -> list, queue, set
     * Map -> map
     * Collection是类的实现总接口
     * Collections可以实现工具方法
     *
     * @return
     */
    public static boolean isEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }

}
