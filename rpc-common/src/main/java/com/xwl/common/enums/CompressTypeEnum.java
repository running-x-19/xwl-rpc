package com.xwl.common.enums;

import lombok.Getter;

/**
 * @Author: xwl
 * @Date: 2023-03-18 21:04:32
 * @Desc: 压缩方式枚举
 */


@Getter
public enum CompressTypeEnum {

    GZIP((byte) 0x01, "gzip");

    private final byte code;

    private final String msg;

    CompressTypeEnum(byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
