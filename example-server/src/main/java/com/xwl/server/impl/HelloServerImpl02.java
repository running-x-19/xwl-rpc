package com.xwl.server.impl;

import com.xwl.hello.operate.Hello;
import com.xwl.hello.operate.HelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: xwl
 * @Date: 2023-03-18 18:47:18
 * @Desc:
 */


@Slf4j
public class HelloServerImpl02 implements HelloService {

    static {
        System.out.println("HelloServiceImpl2被创建");
    }


    /**
     * override 方法
     *
     * @param hello
     * @return
     */
    @Override
    public String hello(Hello hello) {
        log.info("HelloServiceImpl2受到: {}", hello.getMsg());
        String res = "Hello description is" + hello.getDesc();
        log.info("HelloServiceImpl2返回: {}", res);

        return res;
    }

}
