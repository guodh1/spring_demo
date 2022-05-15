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
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 郭东海
 * @since 2022-05-03
 */
@Slf4j
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
@Api(tags = {"渠道管理"})
@RestController
@RequestMapping("/channel")
public class AutoChannelController {

    @Autowired
    AutoChannelService autoChannelService;

    @GetMapping("")
    @ApiOperation("项目列表")
    public ReturnObject list(AutoChannel autoChannel,
                             @RequestParam(value = "pageNum") int pageNum,
                             @RequestParam(value = "pageSize") int pageSize,
                             @RequestParam(value = "order") String order ){
        return autoChannelService.findByAllWithPage(pageNum, pageSize, order, autoChannel);
    }

    @RequestMapping(value = "add", method = {RequestMethod.POST})
    public ReturnObject insert(@RequestBody @Valid AutoChannel autoChannel){
        return autoChannelService.insertChannel(autoChannel);
    }

    @RequestMapping(value = "{id}", method = {RequestMethod.PUT})
    public ReturnObject update(@PathVariable("id") Integer id, @RequestBody @Valid AutoChannel autoChannel){
        return autoChannelService.updateChannel(id, autoChannel);
    }

    @RequestMapping(value = "{id}", method = {RequestMethod.DELETE})
    public ReturnObject delete(@PathVariable("id") Integer id){
        return autoChannelService.deleteChannel(id);
    }
}

