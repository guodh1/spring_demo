package com.sendinfo.auto.controller;


import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.entity.AutoConfig;
import com.sendinfo.auto.entity.AutoEnvs;
import com.sendinfo.auto.page.PageInfo;
import com.sendinfo.auto.service.AutoConfigService;
import com.sendinfo.auto.service.AutoEnvsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 郭东海
 * @since 2022-05-03
 */
@RestController
@RequestMapping("/api/config")
public class AutoConfigController {

    @Autowired
    AutoConfigService autoConfigService;

    @GetMapping("")
    @ApiOperation("配置列表")
    public ReturnObject list(AutoConfig autoConfig, PageInfo pageInfo){
        return autoConfigService.selectConfigList(autoConfig, pageInfo);
    }

    @GetMapping("{id}")
    @ApiOperation("查询配置详情")
    public ReturnObject retrieve(@PathVariable("id") Integer id){
        return autoConfigService.selectConfigById(id);
    }

    @PostMapping(value = "")
    @ApiOperation("添加配置")
    public ReturnObject add(@RequestBody @Valid AutoConfig autoConfig){
        return autoConfigService.insertConfig(autoConfig);
    }

    @PutMapping(value = "{id}")
    @ApiOperation("更新配置")
    public ReturnObject update(@RequestBody @Valid AutoConfig autoConfig, @PathVariable("id") Integer id){
        return autoConfigService.updateByPrimaryKey(autoConfig, id);
    }

    @DeleteMapping(value = "{id}")
    @ApiOperation("删除环境")
    public ReturnObject delete(@PathVariable("id") Integer id){
        return autoConfigService.deleteConfig(id);
    }

}

