package com.xh.aop.controller;

import com.xh.aop.commom.annotation.AccessLimit;
import com.xh.aop.domain.vo.WebApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Name TestController
 * @Description
 * @Author wen
 * @Date 2019-07-11
 */
@RestController
public class TestController {

    @GetMapping("/test")
    @AccessLimit(seconds = 100, maxCount = 3)
    public WebApiResult testAccessLimit(){
        return WebApiResult.success();
    }

}
