package com.xwl.client.operate;

import com.xwl.framework.annotation.RpcReference;
import com.xwl.hello.operate.Hello;
import com.xwl.hello.operate.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xwl
 * @Date: 2023-03-18 16:47:25
 * @Desc:
 */

@Component
public class HelloController {

    /**
     * 注入注解
     */
    @RpcReference(version = "version1", group = "test1")
    private HelloService helloService;

    /**
     * 测试hello
     */
    public void test() throws InterruptedException {
        String hello = this.helloService.hello(new Hello("xwl", "111"));

        TimeUnit.MICROSECONDS.sleep(12000);

        // 隔一段时候, 继续发送消息
        for (int i = 0; i < 10; i++) {
            System.out.println(helloService.hello(new Hello("xwl", "111")));
        }
    }
}
