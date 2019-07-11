package com.xh.aop.commom.enums;


import com.xh.aop.commom.error.CommomError;

/**
 * @author deng.wenqin
 * @Name EmBusinessError
 * @Description 业务错误枚举
 * @Date 2018-03-21
 */
public enum EmError implements CommomError {

    //基本类型
    SUCCESS(0, "操作成功"),
    FAIL(-1, "操作失败"),

    REQUEST_LIMITED(4003, "系统繁忙，请稍后再试"),
    UNKNOWN_ERROR(10001, "未知错误"),
    ;

    private int code;
    private String msg;

    EmError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getErrCode() {
        return this.code;
    }

    @Override
    public String getErrMsg() {
        return this.msg;
    }

    @Override
    public CommomError setErrMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public static EmError codeOf(int index){
        for(EmError state : values()){
            if(state.getErrCode() == index){
                return state;
            }
        }
        return null;
    }

}
