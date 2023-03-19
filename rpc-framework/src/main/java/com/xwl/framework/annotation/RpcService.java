package com.xwl.framework.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * @Author: xwl
 * @Date: 2023-03-18 18:49:19
 * @Desc:
 */

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface RpcService {

    /**
     * 版本号
     *
     * @return
     */
    String version() default "";

    /**
     * 组别
     *
     * @return
     */
    String group() default "";
}
