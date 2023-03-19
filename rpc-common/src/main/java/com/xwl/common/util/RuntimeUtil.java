package com.xwl.common.util;

/**
 * @Author: xwl
 * @Date: 2023-03-18 21:22:49
 * @Desc: 获取CPU的核数
 */


public class RuntimeUtil {

    /**
     * 获取cpu的核数
     *
     * @return
     */
    public static int cpu() {
        return Runtime.getRuntime().availableProcessors();
    }
}
