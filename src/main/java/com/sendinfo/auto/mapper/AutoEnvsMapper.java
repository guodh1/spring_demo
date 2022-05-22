package com.sendinfo.auto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sendinfo.auto.entity.AutoChannel;
import com.sendinfo.auto.entity.AutoChannelExample;
import com.sendinfo.auto.entity.AutoEnvs;

import java.util.List;

import com.sendinfo.auto.page.PageInfo;
import org.apache.ibatis.annotations.Param;


public interface AutoEnvsMapper extends BaseMapper<AutoEnvs> {

    List<AutoEnvs> selectEnvList(@Param("envs") AutoEnvs envs);
    List<AutoEnvs> selectByName(String envsName);
    List<AutoEnvs> selectByPrimaryKey(Integer id);
    int insert(AutoEnvs envs);
    int updateByPrimaryKey(AutoEnvs envs);
    int deleteByPrimaryKey(Integer id);

}