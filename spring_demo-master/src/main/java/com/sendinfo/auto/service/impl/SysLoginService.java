package com.sendinfo.auto.service.impl;

import com.sendinfo.auto.common.Constants;
import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.common.enums.StateCodeEnum;
import com.sendinfo.auto.entity.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;

@Component
public class SysLoginService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    public ReturnObject login(String username, String password) {
        // 用户验证
        Authentication authentication;
        HashMap<String, String> hashMap = new HashMap<>();

        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (Exception e){
            return ReturnObject.getFailBuilder("登录失败",  StateCodeEnum.LOGIN_ERROR.getCode()).build();
        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        hashMap.put(Constants.TOKEN, tokenService.createToken(loginUser));
        hashMap.put("username", loginUser.getUsername());
        // 生成token
        return ReturnObject.getSuccessBuilder(hashMap).build();
    }

}
