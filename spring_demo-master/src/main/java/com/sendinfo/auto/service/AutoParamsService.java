package com.sendinfo.auto.service;

import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.entity.AutoEnvs;
import com.sendinfo.auto.entity.AutoParams;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭东海
 * @since 2022-05-03
 */
public interface AutoParamsService {

    ReturnObject selectParamsByType(String type);
    ReturnObject insertOrUpdateParams(AutoParams autoParams);
}
