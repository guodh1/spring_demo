package com.sendinfo.auto.controller;


import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.common.enums.EnvEnum;
import com.sendinfo.auto.common.enums.ParamEnum;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommonController {

    @GetMapping("/sys_envs")
    @ApiOperation("环境类型")
    public ReturnObject type(){
        return ReturnObject.getSuccessBuilder(EnvEnum.getList()).build();
    }

    @GetMapping("/sys_params")
    @ApiOperation("参数类型")
    public ReturnObject param(){
        return ReturnObject.getSuccessBuilder(ParamEnum.getList()).build();
    }
}

