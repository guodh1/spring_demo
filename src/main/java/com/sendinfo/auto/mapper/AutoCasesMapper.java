package com.sendinfo.auto.mapper;

import com.sendinfo.auto.entity.AutoCases;
import com.sendinfo.auto.entity.AutoCasesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoCasesMapper {
    long countByExample(AutoCasesExample example);

    int deleteByExample(AutoCasesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AutoCases record);

    int insertSelective(AutoCases record);

    List<AutoCases> selectByExampleWithBLOBs(AutoCasesExample example);

    List<AutoCases> selectByExample(AutoCasesExample example);

    AutoCases selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AutoCases record, @Param("example") AutoCasesExample example);

    int updateByExampleWithBLOBs(@Param("record") AutoCases record, @Param("example") AutoCasesExample example);

    int updateByExample(@Param("record") AutoCases record, @Param("example") AutoCasesExample example);

    int updateByPrimaryKeySelective(AutoCases record);

    int updateByPrimaryKeyWithBLOBs(AutoCases record);

    int updateByPrimaryKey(AutoCases record);
}