package com.xwl.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author: xwl
 * @Date: 2023-03-18 20:50:23
 * @Desc:
 */

@ToString
@Getter
public enum RpcResponseCodeEnum {
    SUCCESS(200, "the remote rpc control is success"),
    FAIL(500, "the remote rpc control is fail");

    private int code;
    private String msg;

    RpcResponseCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
