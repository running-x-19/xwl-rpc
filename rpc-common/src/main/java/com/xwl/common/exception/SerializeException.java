package com.xwl.common.exception;

/**
 * @Author: xwl
 * @Date: 2023-03-19 09:25:15
 * @Desc: 序列化异常
 */


public class SerializeException extends RuntimeException {

    /**
     * 序列化异常
     *
     * @param message
     */
    public SerializeException(String message) {
        super(message);
    }
}