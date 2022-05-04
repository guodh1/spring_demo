package com.sendinfo.auto.mapper;

import com.sendinfo.auto.entity.AutoEnvs;
import com.sendinfo.auto.entity.AutoEnvsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoEnvsMapper {
    long countByExample(AutoEnvsExample example);

    int deleteByExample(AutoEnvsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AutoEnvs record);

    int insertSelective(AutoEnvs record);

    List<AutoEnvs> selectByExample(AutoEnvsExample example);

    AutoEnvs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AutoEnvs record, @Param("example") AutoEnvsExample example);

    int updateByExample(@Param("record") AutoEnvs record, @Param("example") AutoEnvsExample example);

    int updateByPrimaryKeySelective(AutoEnvs record);

    int updateByPrimaryKey(AutoEnvs record);
}