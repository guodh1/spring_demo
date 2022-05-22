package com.sendinfo.auto.service;

import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.entity.AutoChannel;
import com.sendinfo.auto.entity.AutoConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sendinfo.auto.entity.AutoEnvs;
import com.sendinfo.auto.page.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭东海
 * @since 2022-05-03
 */
public interface AutoConfigService {

    ReturnObject selectConfigList(AutoConfig keyword, PageInfo pageInfo);
    ReturnObject selectConfigById(Integer id);
    ReturnObject insertConfig(AutoConfig autoConfig);
    ReturnObject updateByPrimaryKey(AutoConfig autoConfig, Integer id);
    ReturnObject deleteConfig(Integer id);

}
