package com.sendinfo.auto.service.impl;

import com.sendinfo.auto.entity.AuthUser;
import com.sendinfo.auto.entity.LoginUser;
import com.sendinfo.auto.mapper.AuthUserMapper;
import com.sendinfo.auto.service.ISysUserService;
import com.sendinfo.auto.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private AuthUserMapper authUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = authUserMapper.selectByName(username);
        return createLoginUser(user);
    }

    public UserDetails createLoginUser(AuthUser user) {
        return new LoginUser(user);
    }
}
