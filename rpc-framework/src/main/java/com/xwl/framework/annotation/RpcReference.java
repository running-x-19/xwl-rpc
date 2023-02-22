package com.xwl.framework.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * @Author: xwl
 * @Date: 2023-02-22 11:17:52
 * @Desc: 使用注解进行服务消费
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface RpcReference {

    /**
     * service version
     * @return
     */
    String version() default "";

    /**
     * service group
     * @return
     */
    String group() default "";
}