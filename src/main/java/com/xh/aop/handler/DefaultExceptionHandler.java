package com.xh.aop.handler;

import com.xh.aop.commom.enums.EmError;
import com.xh.aop.commom.exception.BusinessException;
import com.xh.aop.commom.util.LoggerUtil;
import com.xh.aop.domain.vo.ExceptionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name FileUploacExceptionHandler
 * @Description 全局异常处理器
 * @Author wen
 * @Date 2019-05-30
 */
@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler {

    /**
    * @Name doException
    * @Description 捕获自定义业务异常
    * @Author wen
    * @Date 2019/7/11
    * @param request
    * @param ex
    * @return com.xh.aop.domain.vo.ExceptionResult
    */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ExceptionResult doException(HttpServletRequest request, BusinessException ex){
        LoggerUtil.error(request, ex);
        return ExceptionResult.build(ex);
    }

    /**
    * @Name doException
    * @Description 捕获全局异常
    * @Author wen
    * @Date 2019/7/11
    * @param request
    * @param ex
    * @return com.xh.aop.domain.vo.ExceptionResult
    */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExceptionResult doException(HttpServletRequest request, Exception ex){
        LoggerUtil.exception(request, ex);
        return ExceptionResult.build(EmError.UNKNOWN_ERROR);
    }
}
