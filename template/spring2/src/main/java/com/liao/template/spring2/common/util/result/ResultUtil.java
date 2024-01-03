package com.liao.template.spring2.common.util.result;


import com.liao.template.spring2.common.exception.SimpleException;
import com.liao.template.spring2.common.exception.ISimpleErrorCodeEnum;

public class ResultUtil {
    public static final Integer SUCCESS_CODE = 8000000;
    public static final String SUCCESS_MSG = "操作成功";
    public static final Boolean SUCCESS_STATUS = true;
    public static final Boolean FAILED_STATUS = false;
    public static final String FAILED_MSG = "操作失败";
    public static final Integer SYSTEM_ERROR_CODE = -8000000;
    public static final String SYSTEM_ERROR_MSG = "系统异常";

    public ResultUtil() {
    }

    public static <T> Result<T> success() {
        return new Result(SUCCESS_CODE, "操作成功", SUCCESS_STATUS);
    }

    public static <T> Result<T> success(T t) {
        return new Result(SUCCESS_CODE, t, "操作成功", SUCCESS_STATUS);
    }

    public static <T> Result<T> failed() {
        return new Result(SYSTEM_ERROR_CODE, "系统异常", FAILED_STATUS);
    }

    public static <T> Result<T> failed(Integer errorCode, T t, String errorMsg) {
        return new Result(errorCode, t, errorMsg, FAILED_STATUS);
    }

    public static <T> Result<T> failed(Integer errorCode, String errorMsg) {
        return new Result(errorCode, errorMsg, FAILED_STATUS);
    }

    public static <T> Result<T> failed(SimpleException simpleException) {
        return failed(simpleException.getCode(), simpleException.getMsg());
    }

    public static <T> Result<T> failed(SimpleException simpleException, T t) {
        return failed(simpleException.getCode(), t, simpleException.getMsg());
    }

    public static <T> Result<T> failed(ISimpleErrorCodeEnum simpleErrorCodeEnum) {
        return failed(simpleErrorCodeEnum.getCode(), simpleErrorCodeEnum.getMsg());
    }

    public static <T> Result<T> failed(ISimpleErrorCodeEnum simpleErrorCodeEnum, T t) {
        return failed(simpleErrorCodeEnum.getCode(), t, simpleErrorCodeEnum.getMsg());
    }

    public static <T> T getResultData(Result<T> result) {
        if (null == result) {
            throw new SimpleException(SYSTEM_ERROR_CODE, "系统异常");
        } else if (result.getStatus()) {
            return result.getData();
        } else {
            throw new SimpleException(result.getCode(), result.getMessage());
        }
    }
}
