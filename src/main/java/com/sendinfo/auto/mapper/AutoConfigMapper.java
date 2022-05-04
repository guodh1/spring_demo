package com.sendinfo.auto.mapper;

import com.sendinfo.auto.entity.AutoConfig;
import com.sendinfo.auto.entity.AutoConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoConfigMapper {
    long countByExample(AutoConfigExample example);

    int deleteByExample(AutoConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AutoConfig record);

    int insertSelective(AutoConfig record);

    List<AutoConfig> selectByExampleWithBLOBs(AutoConfigExample example);

    List<AutoConfig> selectByExample(AutoConfigExample example);

    AutoConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AutoConfig record, @Param("example") AutoConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") AutoConfig record, @Param("example") AutoConfigExample example);

    int updateByExample(@Param("record") AutoConfig record, @Param("example") AutoConfigExample example);

    int updateByPrimaryKeySelective(AutoConfig record);

    int updateByPrimaryKeyWithBLOBs(AutoConfig record);

    int updateByPrimaryKey(AutoConfig record);
}