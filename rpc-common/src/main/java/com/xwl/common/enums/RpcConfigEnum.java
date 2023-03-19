package com.xwl.common.enums;

import lombok.Getter;

/**
 * @Author: xwl
 * @Date: 2023-03-18 21:02:49
 * @Desc: rpc 配置类信息
 */

@Getter
public enum RpcConfigEnum {

    RPC_CONFIG_PATH("rpc.properties"),
    ZK_ADDRESS("rpc.zookeeper.address");

    private String propertyValue;

    RpcConfigEnum(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyValue() {
        return propertyValue;
    }
}
