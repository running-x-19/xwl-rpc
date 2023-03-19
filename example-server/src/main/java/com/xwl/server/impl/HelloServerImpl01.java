package com.xwl.server.impl;

import com.xwl.framework.annotation.RpcReference;
import com.xwl.framework.annotation.RpcService;
import com.xwl.hello.operate.Hello;
import com.xwl.hello.operate.HelloService;
import io.protostuff.Rpc;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: xwl
 * @Date: 2023-03-18 18:47:18
 * @Desc:
 */


@Slf4j
@RpcService(version = "version1", group = "test1")
public class HelloServerImpl01 implements HelloService {

    static {
        System.out.println("HelloServerImpl01被创建");
    }

    /**
     * 说句hello
     *
     * @param hello
     * @return
     */
    @Override
    public String hello(Hello hello) {
        log.info("HelloServerImpl受到: {}", hello.getMsg());
        String res = "Hello description is" + hello.getDesc();
        log.info("HelloServerImpl返回: {}", hello.getMsg());
        return res;
    }

}
