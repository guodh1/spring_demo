package com.sendinfo.auto.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.github.pagehelper.PageHelper;
import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.common.enums.StateCodeEnum;
import com.sendinfo.auto.entity.AutoConfig;
import com.sendinfo.auto.entity.AutoEnvs;
import com.sendinfo.auto.mapper.AutoConfigMapper;
import com.sendinfo.auto.mapper.AutoEnvsMapper;
import com.sendinfo.auto.page.PageInfo;
import com.sendinfo.auto.service.AutoConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.netty.util.internal.ObjectUtil;
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
public class AutoConfigServiceImpl implements AutoConfigService {

    @Resource
    AutoConfigMapper autoConfigMapper;

    @Override
    public ReturnObject selectConfigList(AutoConfig autoConfig, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        PageHelper.orderBy(pageInfo.getOrder());
        PageInfo<AutoConfig> page = new PageInfo<>(autoConfigMapper.selectConfigList(autoConfig));
        return ReturnObject.getSuccessBuilder(page).build();
    }

    @Override
    public ReturnObject selectConfigById(Integer id) {
        return ReturnObject.getSuccessBuilder(autoConfigMapper.selectByPrimaryKey(id)).build();
    }

    @Override
    public ReturnObject insertConfig(AutoConfig autoConfig) {
        List<AutoConfig> autoConfigs = autoConfigMapper.selectByName(autoConfig.getName());
        if (autoConfigs.size() >= 1){
            return ReturnObject.getFailBuilder("添加失败，名称已存在", StateCodeEnum.DATA_REPEAT.getCode()).build();
        }
        autoConfigMapper.insert(autoConfig);
        return ReturnObject.getSuccessBuilder("添加成功").build();
    }

    @Override
    public ReturnObject updateByPrimaryKey(AutoConfig autoConfig, Integer id) {
        AutoConfig autoConfigs = autoConfigMapper.selectByPrimaryKey(id);
        if (ObjectUtils.isNull(autoConfigs)){
            return ReturnObject.getFailBuilder("更新失败,未查询到记录", StateCodeEnum.DATA_EMPTY.getCode()).build();
        }
        List<AutoConfig> autoConfigs1 = autoConfigMapper.selectByName(autoConfig.getName());
        if (autoConfigs1.size() > 1){
            return ReturnObject.getFailBuilder("更新失败,名称重复", StateCodeEnum.DATA_REPEAT.getCode()).build();
        }
        autoConfig.setId(id);
        autoConfigMapper.updateByPrimaryKey(autoConfig);
        return ReturnObject.getSuccessBuilder("更新成功").build();
    }

    @Override
    public ReturnObject deleteConfig(Integer id) {
        autoConfigMapper.deleteByPrimaryKey(id);
        return ReturnObject.getSuccessBuilder("删除成功").build();
    }
}
