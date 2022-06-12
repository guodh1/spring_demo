package com.sendinfo.auto.config;

import com.sendinfo.auto.common.enums.StateCodeEnum;
import com.sendinfo.auto.common.ReturnObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


// @ControllerAdvice利用spring aop，如果出现参数校验出错，统一走下面的方法处理
@ControllerAdvice
public class ValidateHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        StringBuilder sb = new StringBuilder();
        // 将错误处理中的字符串拼接下
        for (FieldError fieldError: ex.getBindingResult().getFieldErrors()){
            String defaultMessage = fieldError.getDefaultMessage();
            sb.append(defaultMessage);
            break;
        }
        return new ResponseEntity(ReturnObject.builder()
                .code(StateCodeEnum.VALIDATE_FAIL.getCode())
                .message(sb.toString())
                .success(false)
                .build() ,
                HttpStatus.OK);
    }
}
