package com.xh.aop.commom.util;

import com.xh.aop.commom.error.CommomError;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name LoggerUtil
 * @Description
 * @Author wen
 * @Date 2019-07-11
 */
@Slf4j
public class LoggerUtil {

    public static void error(HttpServletRequest request, CommomError ce){
        String url = request.getRequestURI().toString();
        log.error("BusinessException: [time:{}, url:{}, errorCode:{}, errorMsg:{}]", System.currentTimeMillis(), url, ce.getErrCode(), ce.getErrMsg());
    }

    public static void exception(HttpServletRequest request, Exception ex){
        String url = request.getRequestURI().toString();
        log.error("Exception: [time:{}, url:{}, errorMsg:{}]", System.currentTimeMillis(), url, ex);
    }

}
