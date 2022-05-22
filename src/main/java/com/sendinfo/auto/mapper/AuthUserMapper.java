package com.sendinfo.auto.mapper;

import com.sendinfo.auto.entity.AuthUser;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuthUserMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(AuthUser record);

    int insertSelective(AuthUser record);

    AuthUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthUser record);

    int updateByPrimaryKey(AuthUser record);
}