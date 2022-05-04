package com.sendinfo.auto.mapper;

import com.sendinfo.auto.entity.AutoParams;
import com.sendinfo.auto.entity.AutoParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoParamsMapper {
    long countByExample(AutoParamsExample example);

    int deleteByExample(AutoParamsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AutoParams record);

    int insertSelective(AutoParams record);

    List<AutoParams> selectByExampleWithBLOBs(AutoParamsExample example);

    List<AutoParams> selectByExample(AutoParamsExample example);

    AutoParams selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AutoParams record, @Param("example") AutoParamsExample example);

    int updateByExampleWithBLOBs(@Param("record") AutoParams record, @Param("example") AutoParamsExample example);

    int updateByExample(@Param("record") AutoParams record, @Param("example") AutoParamsExample example);

    int updateByPrimaryKeySelective(AutoParams record);

    int updateByPrimaryKeyWithBLOBs(AutoParams record);

    int updateByPrimaryKey(AutoParams record);
}