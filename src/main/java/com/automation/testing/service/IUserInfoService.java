package com.automation.testing.service;

import com.automation.testing.entity.UserInfo;
import com.automation.testing.request.UserInfoRequest;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author flying
 * @since 2021-11-09
 */
public interface IUserInfoService extends IService<UserInfo> {

    String addInfo(UserInfoRequest userInfoRequest);

    UserInfo queryInfo(String userId);

    String updateInfo(UserInfoRequest userInfoRequest);

    List<UserInfo> queryAllInfo();

    UserInfo logoutUserByUserId(UserInfoRequest userInfoRequest);
}
