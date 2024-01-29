package com.liao.template.spring2.common.aop;

import com.liao.template.spring2.common.exception.SimpleException;
import com.liao.template.spring2.common.util.result.ResultUtil;
import com.liao.template.spring2.common.exception.SimpleErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Object handle(Exception e, HttpServletRequest request) {
        log.error("全局异常", e);
        return ResultUtil.failed(SimpleErrorCodeEnum.ERROR_GLOBAL);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        // 获取校验失败的信息
        FieldError fieldError = e.getBindingResult().getFieldError();
        String errorMessage = fieldError != null ? fieldError.getDefaultMessage() : "未知的参数校验错误";
        log.error("参数不满足条件 {}, 请求地址: {}", errorMessage, request.getRequestURI());
        // 返回校验失败的信息
        return ResultUtil.failed(SimpleErrorCodeEnum.ERROR_PARAM_VALID_FAIL.getCode(), errorMessage);
    }

    @ExceptionHandler(SimpleException.class)
    public Object handleSimpleException(SimpleException e) {
        SimpleException simpleException = e;
        log.error(
                "Exception Code: [{}], Msg: [{}]\n at {}\n at {}",
                simpleException.getCode(),
                simpleException.getMsg(),
                this.printErrorLine(simpleException, 0),
                this.printErrorLine(simpleException, 1));
        return ResultUtil.failed(simpleException);
    }

/*    @ExceptionHandler(IllegalArgumentException.class)
    public Object handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(
                "参数断言失败,  Msg: [{}] thrown at [{}]",
                e.getMessage(),
                this.printErrorLine(e, 1));
        return ResultUtil.failed(SimpleErrorCodeEnum.ERROR_GLOBAL.getCode(), e.getMessage());
    }*/

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        log.error("请求方法不支持, 请求地址: {}", request.getRequestURI(), e);
        return ResultUtil.failed(SimpleErrorCodeEnum.ERROR_GLOBAL.getCode(), "请求方法不支持");
    }


    private String printErrorLine(Throwable e,int line) {
        // 打印报错的那一行
        StackTraceElement[] stackTrace = e.getStackTrace();

        if (stackTrace != null && stackTrace.length > line) {
            return stackTrace[line].toString();
        } else {
            return "全局异常";
        }
    }
}
