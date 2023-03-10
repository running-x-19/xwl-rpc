package com.xwl.hello.operate;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: xwl
 * @Date: 2023-02-21 21:20:24
 * @Desc:
 */

@Data
@Builder
public class Hello implements Serializable {
    private static final long serialVersionUID = -1054321450165531827L;

    private String msg;
    private String desc;
}
