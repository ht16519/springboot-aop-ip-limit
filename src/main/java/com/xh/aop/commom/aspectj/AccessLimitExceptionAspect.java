package com.xh.aop.commom.aspectj;

import com.xh.aop.commom.enums.EmError;
import com.xh.aop.commom.exception.BusinessException;
import com.xh.aop.commom.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Name AccessLimitExceptionAspect
 * @Description 使用aop处理异常请求
 * @Author wen
 * @Date 2019-07-11
 */
@Slf4j
//@Component
//@Aspect
public class AccessLimitExceptionAspect{

    private Exception e;

    //切入点
    @Pointcut("@annotation(com.xh.aop.commom.annotation.AccessLimit)")
    private void bountyHunterPointcut() {
    }

    /**
     * 拦截web层异常，记录异常日志，并返回友好信息到前端
     * @param e 异常对象
     */
    @AfterThrowing(pointcut = "bountyHunterPointcut()", throwing = "e")
    public void handleThrowing(JoinPoint joinPoint, Exception e) {
        this.e = e;
        log.error("发现异常！方法：" + joinPoint.getSignature().getName() + "--->异常", e);
        //这里输入友好性信息
        if (e instanceof BusinessException) {
            ResponseUtil.writer((BusinessException)e);
        } else {
            ResponseUtil.writer(EmError.UNKNOWN_ERROR);
        }
    }


}
