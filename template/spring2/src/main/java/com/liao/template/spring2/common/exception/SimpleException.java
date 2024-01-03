package com.liao.template.spring2.common.exception;

import lombok.Getter;

@Getter
public class SimpleException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String msg;

    public SimpleException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }


}
