package com.liao.template.spring2.common.aop;

import com.liao.template.spring2.common.exception.SimpleException;
import com.liao.template.spring2.common.util.result.ResultUtil;
import com.liao.template.spring2.common.exception.SimpleErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handle(Exception e, HttpServletRequest request) {
        if (e instanceof SimpleException) {
            SimpleException simpleException = (SimpleException) e;
            // 打印报错的那一行
            this.printErrorLine(simpleException);
            log.error("Exception Code: [{}], Msg: [{}] thrown at [{}]",
                    simpleException.getCode(),
                    simpleException.getMsg(),
                    this.printErrorLine(simpleException));

            return ResultUtil.failed(simpleException);
        }
        log.error("全局异常", e);
        return ResultUtil.failed(SimpleErrorCodeEnum.ERROR_GLOBAL);
    }

    private String printErrorLine(SimpleException e) {
        // 打印报错的那一行
        StackTraceElement[] stackTrace = e.getStackTrace();

        if (stackTrace != null && stackTrace.length > 0) {
            return stackTrace[0].toString();
        } else {
            return "全局异常";
        }
    }
}
