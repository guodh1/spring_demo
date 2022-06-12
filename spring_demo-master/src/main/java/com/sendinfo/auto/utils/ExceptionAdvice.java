package com.sendinfo.auto.utils;

import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.common.enums.StateCodeEnum;
import com.sendinfo.auto.utils.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
@Slf4j
public class ExceptionAdvice{

    @ExceptionHandler(BusinessException.class)
    public ReturnObject handleBizException(BusinessException e) {
        ReturnObject returnObject = new ReturnObject();
        returnObject.setMessage(e.getMessage());
        returnObject.setSuccess(false);
        return returnObject ;
    }


}


