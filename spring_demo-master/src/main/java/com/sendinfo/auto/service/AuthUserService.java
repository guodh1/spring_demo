package com.sendinfo.auto.service;

import com.sendinfo.auto.common.ReturnObject;
import com.sendinfo.auto.entity.AuthUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 郭东海
 * @since 2022-05-03
 */
public interface AuthUserService {
    ReturnObject insertUser(AuthUser authUser);
    ReturnObject updateUser(Integer id, AuthUser authUser);
    ReturnObject deleteUser(Integer id);

}
