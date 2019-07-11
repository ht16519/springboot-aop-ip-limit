package com.xh.aop.domain.vo;


import com.xh.aop.commom.error.CommomError;
import lombok.Data;

import javax.swing.text.rtf.RTFEditorKit;

/**
 * @Name ExceptionResult
 * @Description 全局异常返回结果
 * @Author wen
 * @Date 2019-03-30
 */
@Data
public class ExceptionResult {

    private int code;

    private String msg;

    private long timestamp;

    public ExceptionResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.timestamp = System.currentTimeMillis();
    }

    public static ExceptionResult build(CommomError commomError){
        return build(commomError.getErrCode(), commomError.getErrMsg());
    }

    public static ExceptionResult build(int code, String msg){
        return new ExceptionResult(code, msg);
    }

}
