package com.sendinfo.auto.service;

import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.entity.AutoChannel;
import com.sendinfo.auto.entity.AutoEnvs;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sendinfo.auto.page.PageInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭东海
 * @since 2022-05-03
 */
public interface AutoEnvsService{

    ReturnObject selectEnvList(AutoEnvs keyword, PageInfo pageInfo);
    ReturnObject selectEnvById(Integer id);
    ReturnObject insertEnvs(AutoEnvs autoEnvs);
    ReturnObject updateByPrimaryKey(AutoEnvs autoEnvs, Integer id);
    ReturnObject deleteEnvs(Integer id);
}
