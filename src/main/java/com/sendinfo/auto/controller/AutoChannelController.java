package com.sendinfo.auto.controller;


import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.entity.AutoChannel;
import com.sendinfo.auto.page.PageInfo;
import com.sendinfo.auto.service.AutoChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author 郭东海
 * @since 2022-05-03
 */
@Slf4j
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
@Api(tags = {"渠道管理"})
@RestController
@RequestMapping("/api/channel")
public class AutoChannelController {

    @Autowired
    AutoChannelService autoChannelService;

    @GetMapping("")
    @ApiOperation("渠道列表")
    public ReturnObject list(AutoChannel autoChannel,
                             @RequestParam(value = "pageNum") int pageNum,
                             @RequestParam(value = "pageSize") int pageSize,
                             @RequestParam(value = "order") String order ){
        return autoChannelService.findByAllWithPage(pageNum, pageSize, order, autoChannel);
    }

    @GetMapping("{id}")
    @ApiOperation("查询渠道详情")
    public ReturnObject retrieve(@PathVariable("id") Integer id){
        return autoChannelService.selectChannelById(id);
    }

    @RequestMapping(value = "add", method = {RequestMethod.POST})
    public ReturnObject insert(@RequestBody @Valid AutoChannel autoChannel){
        return autoChannelService.insertChannel(autoChannel);
    }

    @PutMapping(value = "{id}")
    public ReturnObject update(@PathVariable("id") Integer id, @RequestBody @Valid AutoChannel autoChannel){
        return autoChannelService.updateChannel(id, autoChannel);
    }

    @DeleteMapping(value = "{id}")
    public ReturnObject delete(@PathVariable("id") Integer id){
        return autoChannelService.deleteChannel(id);
    }
}

