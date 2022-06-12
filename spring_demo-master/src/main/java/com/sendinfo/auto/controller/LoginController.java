package com.sendinfo.auto.controller;

import com.sendinfo.auto.common.Constants;
import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.service.impl.SysLoginService;
import com.sendinfo.auto.service.impl.TokenService;
import com.sendinfo.auto.vo.LoginBodyVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private SysLoginService loginService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public ReturnObject login(@RequestBody LoginBodyVo loginBody) {

        return loginService.login(loginBody.getUsername(), loginBody.getPassword());
    }
}
