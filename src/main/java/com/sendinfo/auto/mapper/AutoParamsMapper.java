package com.sendinfo.auto.mapper;

import com.sendinfo.auto.entity.AutoParams;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoParamsMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(AutoParams record);

    int insertSelective(AutoParams record);

    AutoParams selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutoParams record);

    int updateByPrimaryKeyWithBLOBs(AutoParams record);

    int updateByPrimaryKey(AutoParams record);
}