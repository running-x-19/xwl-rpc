package com.xwl.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @Author: xwl
 * @Date: 2023-03-18 20:56:32
 * @Desc: 序列化类型枚举类
 */

@AllArgsConstructor
@Getter
@ToString
public enum SerializationTypeEnum {

    /**
     * SerializationTypeEnum
     * 三种序列化方式
     */
    KYRO((byte) 0x01, "kyro"),
    PROTOSTUFF((byte) 0x02, "protostuff"),
    HESSIAN((byte) 0x03, "hessian");

    private final byte code;

    private final String name;

    /**
     * 获取到名字
     *
     * @param code
     * @return
     */
    public static String getName(byte code) {
        // 遍历每种枚举遍历
        for (SerializationTypeEnum c : SerializationTypeEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }

        return null;
    }

}