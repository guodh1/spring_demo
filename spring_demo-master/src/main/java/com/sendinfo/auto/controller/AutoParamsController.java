package com.sendinfo.auto.controller;


import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.entity.AutoParams;
import com.sendinfo.auto.service.AutoParamsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
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
@RequestMapping("/api/params")
public class AutoParamsController {

    @Autowired
    AutoParamsService autoParamsService;

    @GetMapping("{type}")
    @ApiOperation("参数详情")
    public ReturnObject retrieve(@PathVariable("type") String type){
        return autoParamsService.selectParamsByType(type);
    }

    @PostMapping("{type}")
    @ApiOperation("添加或更新参数")
    public ReturnObject createOrUpdate(@PathVariable("type") String type, @RequestBody @Valid AutoParams autoParams){
        return autoParamsService.insertOrUpdateParams(autoParams);
    }

}

