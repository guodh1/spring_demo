package com.sendinfo.auto.utils;

import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.utils.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public ReturnObject handleBizException(BusinessException e) {
        ReturnObject returnObject = new ReturnObject();
        returnObject.setMessage(e.getMessage());
        return returnObject ;
    }

}


