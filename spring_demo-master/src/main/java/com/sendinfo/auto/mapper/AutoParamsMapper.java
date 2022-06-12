package com.sendinfo.auto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sendinfo.auto.entity.AutoEnvs;
import com.sendinfo.auto.entity.AutoParams;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoParamsMapper extends BaseMapper<AutoParams> {

    int deleteByPrimaryKey(Integer id);

    int insert(AutoParams record);

    int insertSelective(AutoParams record);

    AutoParams selectByPrimaryKey(Integer id);

    AutoParams selectByType(String type);

    int updateByPrimaryKeySelective(AutoParams record);

    int updateByPrimaryKeyWithBLOBs(AutoParams record);

    int updateByPrimaryKey(AutoParams record);

    int updateByType(AutoParams record);
}