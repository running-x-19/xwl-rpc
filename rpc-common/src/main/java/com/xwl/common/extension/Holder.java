package com.xwl.common.extension;

/**
 * @Author: xwl
 * @Date: 2023-03-19 09:30:15
 * @Desc:
 */


public class Holder<T> {

    private volatile T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return this.value;
    }

}
