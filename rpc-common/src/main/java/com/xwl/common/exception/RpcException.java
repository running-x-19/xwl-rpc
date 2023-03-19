package com.xwl.common.exception;

import com.xwl.common.enums.RpcErrorMessageEnum;

/**
 * @Author: xwl
 * @Date: 2023-03-18 20:43:45
 * @Desc: 集成runtimeException
 */


public class RpcException extends RuntimeException {

    /**
     * 给出具体细节的异常
     *
     * @param messageEnum
     * @param detail
     */
    public RpcException(RpcErrorMessageEnum messageEnum, String detail) {
        super(messageEnum.getMsg() + detail);
    }

    /**
     * throwable -> error | exception
     *
     * @param message
     * @param throwable
     */
    public RpcException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * 发送信息
     *
     * @param messageEnum
     */
    public RpcException(RpcErrorMessageEnum messageEnum) {
        super(messageEnum.getMsg());
    }

}