package com.xwl.common.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * @Author: xwl
 * @Date: 2023-03-18 20:44:45
 * @Desc: Rpc信息枚举类
 */


@ToString
@Getter
public enum RpcErrorMessageEnum {

    CLIENT_CONNECT_SERVER_FAILURE("客户端连接错误"),
    SERVICE_INVOCATION_FAILURE("服务端调用失败"),
    SERVICE_CAN_NOT_BE_FOUND("没有找到指定的服务"),
    SERVICE_NOT_IMPLEMENT_ANY_INTERFACE("组测的服务没有实现任何接口"),
    REQUEST_NOT_MATCH_REQUEST("返回结果错误, 请求和返回不匹配");

    private String msg;

    RpcErrorMessageEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}