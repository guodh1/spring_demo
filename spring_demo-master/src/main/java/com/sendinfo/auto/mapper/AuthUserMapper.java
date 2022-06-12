package com.sendinfo.auto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sendinfo.auto.entity.AuthUser;

import java.util.List;

import com.sendinfo.auto.entity.AutoEnvs;
import org.apache.ibatis.annotations.Param;

public interface AuthUserMapper extends BaseMapper<AuthUser> {


    int deleteByPrimaryKey(Integer id);

    int insert(AuthUser record);

    int insertSelective(AuthUser record);

    List<AuthUser> selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthUser record);

    int updateByPrimaryKey(AuthUser record);

    int updatePasswordPrimaryKey(String password);

    AuthUser selectByName(String userName);


}