package com.sendinfo.auto.service.impl;

import com.github.pagehelper.PageHelper;
import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.common.enums.StateCodeEnum;
import com.sendinfo.auto.entity.AutoChannel;
import com.sendinfo.auto.entity.AutoEnvs;
import com.sendinfo.auto.mapper.AutoEnvsMapper;
import com.sendinfo.auto.page.PageInfo;
import com.sendinfo.auto.service.AutoEnvsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sendinfo.auto.utils.AssertUtil;
import com.xiaoleilu.hutool.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 郭东海
 * @since 2022-05-03
 */
@Service
public class AutoEnvsServiceImpl implements AutoEnvsService {

    @Resource
    AutoEnvsMapper autoEnvsMapper;

    @Override
    public ReturnObject selectEnvList(AutoEnvs autoEnvs, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        // PageHelper.orderBy 参数为字符串如: create_time asc或create_time desc
        PageHelper.orderBy(pageInfo.getOrder());
        PageInfo<AutoEnvs> page = new PageInfo<>(autoEnvsMapper.selectEnvList(autoEnvs));
        return ReturnObject.getSuccessBuilder(page).build();
    }

    @Override
    public ReturnObject selectEnvById(Integer id) {
        return ReturnObject.getSuccessBuilder(autoEnvsMapper.selectByPrimaryKey(id)).build();
    }

    @Override
    public ReturnObject insertEnvs(AutoEnvs autoEnvs) {
        List<AutoEnvs> autoEnvsList = autoEnvsMapper.selectByName(autoEnvs.getName());
        if (autoEnvsList.size() >= 1){
            return ReturnObject.getFailBuilder("添加失败，名称已存在", StateCodeEnum.DATA_REPEAT.getCode()).build();
        }
        autoEnvsMapper.insert(autoEnvs);
        return ReturnObject.getSuccessBuilder("添加成功").build();
    }

    @Override
    public ReturnObject updateByPrimaryKey(AutoEnvs autoEnvs, Integer id) {
        AutoEnvs autoEnv= autoEnvsMapper.selectByPrimaryKey(id);
        if (ObjectUtil.isNull(autoEnv)){
            return ReturnObject.getFailBuilder("更新失败,未查询到记录", StateCodeEnum.DATA_EMPTY.getCode()).build();
        }
        List<AutoEnvs> autoEnvsList = autoEnvsMapper.selectByName(autoEnvs.getName());
        if (autoEnvsList.size() > 1){
            return ReturnObject.getFailBuilder("更新失败,名称重复", StateCodeEnum.DATA_REPEAT.getCode()).build();
        }
        autoEnvs.setId(id);
        autoEnvsMapper.updateByPrimaryKey(autoEnvs);
        return ReturnObject.getSuccessBuilder("更新成功").build();
    }

    @Override
    public ReturnObject deleteEnvs(Integer id) {
        autoEnvsMapper.deleteByPrimaryKey(id);
        return ReturnObject.getSuccessBuilder("删除成功").build();
    }

}
