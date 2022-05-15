package com.sendinfo.auto.service.impl;

import com.github.pagehelper.PageHelper;
import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.common.enums.StateCodeEnum;
import com.sendinfo.auto.entity.AutoChannel;
import com.sendinfo.auto.entity.AutoChannelExample;
import com.sendinfo.auto.mapper.AutoChannelMapper;
import com.sendinfo.auto.page.PageInfo;
import com.sendinfo.auto.service.AutoChannelService;
import com.sendinfo.auto.utils.AssertUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 郭东海
 * @since 2022-05-03
 */
@Service
public class AutoChannelServiceImpl implements AutoChannelService {

    @Resource
    private AutoChannelMapper autoChannelMapper;

    @Override
    public ReturnObject findByAllWithPage(int pageNum, int pageSize, String order, AutoChannel keyword) {
        AutoChannelExample autoChannelExample = new AutoChannelExample();
        autoChannelExample.setOrderByClause(order);
        autoChannelExample.setKeyword(keyword);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<AutoChannel> pageInfo = new PageInfo<>(autoChannelMapper.selectByExample(autoChannelExample));
        return ReturnObject.getSuccessBuilder(pageInfo).build();
    }

    @Override
    public ReturnObject insertChannel(AutoChannel autoChannel) {
        AutoChannelExample autoChannelExample = new AutoChannelExample();
        // 创建criteria，可调用其中的方法来添加where条件
        AutoChannelExample.Criteria criteria = autoChannelExample.createCriteria();
        // 相当于添加where条件，where name=xxx
        criteria.andNameEqualTo(autoChannel.getName());
        // 添加完条件后去数据库查询是否已存在渠道
        List<AutoChannel> autoChannels = autoChannelMapper.selectByExample(autoChannelExample);

        if (autoChannels.size() > 0){
            return ReturnObject.getFailBuilder("渠道信息已存在").build();
        }
        autoChannelMapper.insert(autoChannel);
        return ReturnObject.getSuccessBuilder("添加渠道成功").build();

    }

    @Override
    public ReturnObject updateChannel(Integer id, AutoChannel autoChannel) {
        AutoChannelExample autoChannelExample = new AutoChannelExample();
        AutoChannelExample.Criteria criteria = autoChannelExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<AutoChannel> autoChannels = autoChannelMapper.selectByExample(autoChannelExample);
        AssertUtil.isTrue(autoChannels.size() >= 1, "更新失败，未查询到渠道信息");

        AutoChannelExample autoChannelExample1 = new AutoChannelExample();
        criteria = autoChannelExample1.createCriteria();
        criteria.andNameEqualTo(autoChannel.getName());
        List<AutoChannel> autoChannels1 = autoChannelMapper.selectByExample(autoChannelExample1);
        AssertUtil.isTrue(autoChannels1.size() < 1, "更新失败，渠道名称已存在");

        if (autoChannels.size() > 0){
            autoChannel.setId(id);
            autoChannelMapper.updateByPrimaryKey(autoChannel);
        }
        return ReturnObject.getSuccessBuilder("更新成功").build();
    }

    @Override
    public ReturnObject deleteChannel(Integer id) {

        AutoChannelExample autoChannelExample= new AutoChannelExample();
        AutoChannelExample.Criteria criteria = autoChannelExample.createCriteria();
        criteria.andIdEqualTo(id);
        autoChannelMapper.deleteByPrimaryKey(id);
        return ReturnObject.getSuccessBuilder("删除成功").build();
    }
}
