package com.sendinfo.auto.common;

import com.sendinfo.auto.common.enums.StateCodeEnum;
import lombok.*;

import java.io.Serializable;
import java.util.Map;

// @NoArgsConstructor @AllArgsConstructor添加无参构造和所有参数构造，一般和@Builder结合使用
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
@Data
public class ReturnObject implements Serializable {
    private Integer code = 200;
    private String message = "";
    private Boolean success = true;
    private Object result;


    public  static ReturnObject.ReturnObjectBuilder getSuccessBuilder(Object object){
        // 因为存在@Builder注解，所以ResultWrapper.builder().code()返回的还是自己，可以继续进行调用
        return ReturnObject.builder()
                .code(StateCodeEnum.SUCCESS.getCode())
                .message(null)
                .result(object)
                .success(true);
    }

    public  static ReturnObject.ReturnObjectBuilder getSuccessBuilder(Map map){
        // 因为存在@Builder注解，所以ResultWrapper.builder().code()返回的还是自己，可以继续进行调用
        return ReturnObject.builder()
                .code(StateCodeEnum.SUCCESS.getCode())
                .message(null)
                .result(map)
                .success(true);
    }


    public  static ReturnObject.ReturnObjectBuilder getSuccessBuilder(String sting){
        return ReturnObject.builder()
                .code(StateCodeEnum.SUCCESS.getCode())
                .message(sting)
                .result(null)
                .success(true);
    }

    public static ReturnObject.ReturnObjectBuilder getFailBuilder(String sting, int code){
        return ReturnObject.builder()
                .code(code)
                .message(sting)
                .result(null)
                .success(false);
    }

    public static ReturnObject.ReturnObjectBuilder getFailBuilder(int code){
        return ReturnObject.builder()
                .code(code)
                .message(null)
                .result(null)
                .success(false);
    }

}
