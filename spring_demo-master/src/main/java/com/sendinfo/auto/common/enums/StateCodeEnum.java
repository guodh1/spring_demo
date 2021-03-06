package com.sendinfo.auto.common.enums;

import lombok.Data;

public enum  StateCodeEnum {

    /*
     *   用户模块4010-4019
     *   渠道模块4020-4039
     *   环境模块4040-4049
     *   用例模块4050-4069
     *   配置模块4070-4080
     *   公共报错4001-4009
     * */
    LOGIN_ERROR(4011,"登录失败"),

    USER_EMPTY(4012,"用户不存在"),

    ERROR(5001,"请求失败"),

    FAIL(4001,"请求失败"),

    VALIDATE_FAIL(4002,"参数校验出错"),

    DATA_REPEAT(4003, "数据已存在"),

    DATA_EMPTY(4003, "数据不存在"),

    SUCCESS(2001,"请求成功");


    private  int code;
    private String msg;

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    private Boolean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    StateCodeEnum(int code , String msg){
        this.code = code;
        this.msg = msg;
    }
}
