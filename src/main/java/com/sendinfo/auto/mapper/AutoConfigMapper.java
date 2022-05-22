package com.sendinfo.auto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sendinfo.auto.entity.AutoConfig;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AutoConfigMapper extends BaseMapper<AutoConfig> {

    List<AutoConfig> selectConfigList(@Param("config") AutoConfig autoConfig);
    List<AutoConfig> selectByName(String envsName);
    List<AutoConfig> selectByPrimaryKey(Integer id);
    int insert(AutoConfig config);
    int updateByPrimaryKey(AutoConfig config);
    int deleteByPrimaryKey(Integer id);
}