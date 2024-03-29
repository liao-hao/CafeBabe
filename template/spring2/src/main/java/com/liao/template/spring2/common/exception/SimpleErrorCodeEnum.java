package com.liao.template.spring2.common.exception;

public enum SimpleErrorCodeEnum implements ISimpleErrorCodeEnum {

    ERROR_GLOBAL(-8000000, "全局异常"),
    ERROR_PARAM_VALID_FAIL(-80000001, "参数校验失败"),
    ;

    private Integer code;

    private String msg;

    private SimpleErrorCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
