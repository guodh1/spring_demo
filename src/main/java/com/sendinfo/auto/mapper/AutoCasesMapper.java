package com.sendinfo.auto.mapper;

import com.sendinfo.auto.entity.AutoCases;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoCasesMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(AutoCases record);

    int insertSelective(AutoCases record);


    AutoCases selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutoCases record);

    int updateByPrimaryKeyWithBLOBs(AutoCases record);

    int updateByPrimaryKey(AutoCases record);
}