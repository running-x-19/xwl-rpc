package com.xwl.framework.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * @Author: xwl
 * @Date: 2023-03-18 18:49:19
 * @Desc:
 */

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface RpcScan {

    String[] basePackage();

}
