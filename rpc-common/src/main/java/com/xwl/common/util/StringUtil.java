package com.xwl.common.util;

/**
 * @Author: xwl
 * @Date: 2023-03-18 21:23:56
 * @Desc: string 处理类 判断是否为空
 */


public class StringUtil {

    /**
     * 判断是否为空
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {

        if (str == null || str.length() == 0) {
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

}