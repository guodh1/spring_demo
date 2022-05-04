package com.sendinfo.auto.service.impl;

import com.github.pagehelper.PageHelper;
import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.entity.AutoChannel;
import com.sendinfo.auto.entity.AutoChannelExample;
import com.sendinfo.auto.mapper.AutoChannelMapper;
import com.sendinfo.auto.page.PageInfo;
import com.sendinfo.auto.service.AutoChannelService;
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
    public ReturnObject findByAllWithPage(int pageNum, int pageSize, String order) {
        AutoChannelExample autoChannelExample = new AutoChannelExample();
        autoChannelExample.setOrderByClause(order);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<AutoChannel> pageInfo = new PageInfo<>(autoChannelMapper.selectByExample(autoChannelExample));
        ReturnObject returnObject = new ReturnObject(pageInfo);
        returnObject.setMessage("查询成功");
        return returnObject;
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
        ReturnObject returnObject = new ReturnObject();
        if (autoChannels.size() > 0){
            returnObject.setMessage("渠道信息已存在");
            return returnObject;
        }
        autoChannelMapper.insert(autoChannel);
        returnObject.setMessage("添加渠道成功");
        return returnObject;
    }
}
