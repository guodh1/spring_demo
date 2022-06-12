package com.sendinfo.auto.controller;


import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.entity.AuthUser;
import com.sendinfo.auto.service.AuthUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@RequestMapping("/api/user")
public class AuthUserController {


    @Autowired
    AuthUserService authUserService;

    @PostMapping(value = "")
    @ApiOperation("新增用户")
    public ReturnObject insert(@RequestBody @Valid AuthUser authUser){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        authUser.setPassword(passwordEncoder.encode(authUser.getPassword()));
        return authUserService.insertUser(authUser);
    }

    @PutMapping(value = "{id}")
    @ApiOperation("修改用户信息")
    public ReturnObject update(@PathVariable("id") Integer id, @RequestBody @Valid AuthUser authUser){
        return authUserService.updateUser(id, authUser);
    }

    @DeleteMapping(value = "{id}")
    public ReturnObject delete(@PathVariable("id") Integer id){
        return authUserService.deleteUser(id);
    }
}

