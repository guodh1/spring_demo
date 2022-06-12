package com.sendinfo.auto.service.impl;

import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.common.enums.StateCodeEnum;
import com.sendinfo.auto.entity.AuthUser;
import com.sendinfo.auto.entity.AutoEnvs;
import com.sendinfo.auto.mapper.AuthUserMapper;
import com.sendinfo.auto.service.AuthUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
public class AuthUserServiceImpl implements AuthUserService {


    @Resource
    AuthUserMapper authUserMapper;

    @Override
    public ReturnObject insertUser(AuthUser authUser) {
        AuthUser authUser1 = authUserMapper.selectByName(authUser.getUsername());
        if (null != authUser1 && !authUser1.getUsername().isEmpty()){
            return ReturnObject.getFailBuilder("添加失败，用户已存在", StateCodeEnum.DATA_REPEAT.getCode()).build();
        }
        authUser.setLoginDate(new Date());
        authUserMapper.insert(authUser);
        return ReturnObject.getSuccessBuilder("添加成功").build();
    }

    @Override
    public ReturnObject updateUser(Integer id, AuthUser authUser) {
        List<AuthUser> authUserList = authUserMapper.selectByPrimaryKey(id);
        if (authUserList.size() < 1){
            return ReturnObject.getFailBuilder("更新失败,未查询到记录", StateCodeEnum.DATA_EMPTY.getCode()).build();
        }
        authUser.setId(id);
        authUserMapper.updatePasswordPrimaryKey(authUser.getPassword());
        return ReturnObject.getSuccessBuilder("更新成功").build();
    }

    @Override
    public ReturnObject deleteUser(Integer id) {
        authUserMapper.deleteByPrimaryKey(id);
        return ReturnObject.getSuccessBuilder("删除成功").build();
    }
}
