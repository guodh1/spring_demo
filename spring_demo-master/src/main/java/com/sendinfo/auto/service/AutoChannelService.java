package com.sendinfo.auto.service;

import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.entity.AutoChannel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sendinfo.auto.page.PageInfo;
import io.swagger.models.auth.In;

/**
 * @author 郭东海
 * @since 2022-05-03
 */
public interface AutoChannelService{

    ReturnObject findByAllWithPage(int pageNum, int pageSize, String order, AutoChannel keyword);
    ReturnObject selectChannelById(Integer id);
    ReturnObject insertChannel(AutoChannel autoChannel);
    ReturnObject updateChannel(Integer id, AutoChannel autoChannel);
    ReturnObject deleteChannel(Integer id);

}
