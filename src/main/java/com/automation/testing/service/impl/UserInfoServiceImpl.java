package com.automation.testing.service.impl;

import com.automation.testing.entity.UserInfo;
import com.automation.testing.mapper.UserInfoMapper;
import com.automation.testing.request.UserInfoRequest;
import com.automation.testing.service.IUserInfoService;
import com.automation.testing.utils.GeneratID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author flying
 * @since 2021-11-09
 */
@Service
@Primary
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public String addInfo(UserInfoRequest userInfoRequest) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoRequest,userInfo);
        String userId = String.valueOf(GeneratID.getGeneratID());
        userInfo.setUserId(userId);
        userInfoMapper.insert(userInfo);
        return userId;
    }

    @Override
    public UserInfo queryInfo(String userId) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>();
        wrapper.eq("user_id",userId);
        UserInfo userInfo = userInfoMapper.selectOne(wrapper);
        return userInfo;
    }

    @Override
    public String updateInfo(UserInfoRequest userInfoRequest) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfoRequest,userInfo);
        int id = userInfoMapper.updateById(userInfo);
        return userInfo.getUserId();
    }

    @Override
    public List<UserInfo> queryAllInfo() {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>();
        wrapper.eq("user_status",1);
        List<UserInfo> userInfos = userInfoMapper.selectList(wrapper);
        return userInfos;
    }

    @Override
    public  UserInfo logoutUserByUserId(UserInfoRequest userInfoRequest) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>();
        wrapper.eq("user_id",userInfoRequest.getUserId());
        UserInfo userInfo = new UserInfo();
        userInfo.setUserStatus(0);
        int update = userInfoMapper.update(userInfo, wrapper);

        QueryWrapper<UserInfo> wrapper1 = new QueryWrapper<UserInfo>();
        wrapper1.eq("user_id",userInfoRequest.getUserId());
        UserInfo userInfo1 = userInfoMapper.selectOne(wrapper1);
        return userInfo1;
    }
}
