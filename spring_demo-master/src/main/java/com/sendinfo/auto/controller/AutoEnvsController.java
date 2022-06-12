package com.sendinfo.auto.controller;


import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.common.enums.EnvEnum;
import com.sendinfo.auto.entity.AutoEnvs;
import com.sendinfo.auto.page.PageInfo;
import com.sendinfo.auto.service.AutoEnvsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

/**
 * @author 郭东海
 * @since 2022-05-03
 */
@RestController
@RequestMapping("/api/envs")
public class AutoEnvsController {

    @Autowired
    AutoEnvsService autoEnvsService;

    @GetMapping("")
    @ApiOperation("环境列表")
    public ReturnObject list(AutoEnvs autoEnvs, PageInfo pageInfo){
        return autoEnvsService.selectEnvList(autoEnvs, pageInfo);
    }

    @GetMapping("{id}")
    @ApiOperation("查询环境详情")
    public ReturnObject retrieve(@PathVariable("id") Integer id){
        return autoEnvsService.selectEnvById(id);
    }

    @PostMapping(value = "")
    @ApiOperation("添加环境")
    public ReturnObject add(@RequestBody @Valid AutoEnvs autoEnvs){
        return autoEnvsService.insertEnvs(autoEnvs);
    }

    @PutMapping(value = "{id}")
    @ApiOperation("更新环境")
    public ReturnObject update(@RequestBody @Valid AutoEnvs autoEnvs, @PathVariable("id") Integer id){
        return autoEnvsService.updateByPrimaryKey(autoEnvs, id);
    }

    @DeleteMapping(value = "{id}")
    @ApiOperation("删除环境")
    public ReturnObject delete(@PathVariable("id") Integer id){
        return autoEnvsService.deleteEnvs(id);
    }

}

