package com.sendinfo.auto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sendinfo.auto.entity.AutoChannel;
import com.sendinfo.auto.entity.AutoChannelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AutoChannelMapper extends BaseMapper<AutoChannel> {
    long countByExample(AutoChannelExample example);

    int deleteByExample(AutoChannelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AutoChannel record);

    int insertSelective(AutoChannel record);

    List<AutoChannel> selectByExample(AutoChannelExample example);

    AutoChannel selectChannelById(Integer id);

    int update(@Param("record") AutoChannel record, @Param("example") AutoChannelExample example);

    int updateByExample(@Param("record") AutoChannel record, @Param("example") AutoChannelExample example);

    int updateByPrimaryKeySelective(AutoChannel record);

    int updateByPrimaryKey(AutoChannel record);
}