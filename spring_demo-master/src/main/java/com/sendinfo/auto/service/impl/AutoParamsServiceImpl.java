package com.sendinfo.auto.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.common.enums.StateCodeEnum;
import com.sendinfo.auto.entity.AutoParams;
import com.sendinfo.auto.mapper.AutoParamsMapper;
import com.sendinfo.auto.service.AutoParamsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sendinfo.auto.utils.FastJsonHelper;
import io.netty.util.internal.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AutoParamsServiceImpl  implements AutoParamsService {

    @Resource
    AutoParamsMapper autoParamsMapper;

    @Override
    public ReturnObject selectParamsByType(String type) {
        AutoParams autoParam = autoParamsMapper.selectByType(type);
        return ReturnObject.getSuccessBuilder(autoParam).build();
    }

    @Override
    public ReturnObject insertOrUpdateParams(AutoParams autoParams) {
        // json解析
        String params = autoParams.getParams();
        JSONObject paramsJsonObject = JSONObject.parseObject(params);
        if (ObjectUtils.isNull(paramsJsonObject)){
            return ReturnObject.getFailBuilder("json解析错误", StateCodeEnum.VALIDATE_FAIL.getCode()).build();
        }

        AutoParams autoParam = autoParamsMapper.selectByType(autoParams.getType());
        // 存在记录则更新
        if (!ObjectUtils.isNull(autoParam)){
            autoParams.setType(autoParams.getType());
            System.out.println(autoParams.getParams());
            autoParamsMapper.updateByType(autoParams);
            return ReturnObject.getSuccessBuilder("更新成功").build();
        }

        autoParamsMapper.insert(autoParams);
        return ReturnObject.getSuccessBuilder("新增成功").build();
    }
}
