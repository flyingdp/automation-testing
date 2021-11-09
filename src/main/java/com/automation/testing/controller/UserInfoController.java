package com.automation.testing.controller;


import com.automation.testing.entity.UserInfo;
import com.automation.testing.request.UserInfoRequest;
import com.automation.testing.response.Response;
import com.automation.testing.response.ResponseResult;
import com.automation.testing.response.ResultCode;
import com.automation.testing.response.UserInfoRsponse;
import com.automation.testing.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author flying
 * @since 2021-11-09
 */
@RestController
@RequestMapping("/user-info")
@ResponseBody
public class UserInfoController {

    @Autowired
    private IUserInfoService userInfoService;

    //新增用户-add
    @PostMapping("/add")
    public ResponseResult<UserInfoRsponse> addUserInfo(@RequestBody UserInfoRequest userInfoRequest){
        String userId = userInfoService.addInfo(userInfoRequest);
        UserInfoRsponse userInfoRsponse = new UserInfoRsponse();
        userInfoRsponse.setUserId(userId);
        return Response.makeOKResponse(userInfoRsponse);
    }

    //查询用户-query
    @PostMapping("/query")
    public ResponseResult<UserInfo> queryInfo(@RequestBody String userId){
        UserInfo userInfo = userInfoService.queryInfo(userId);
        return Response.makeOKResponse(userInfo);
    }

    //修改用户信息-edit
    @PostMapping("/edit")
    public ResponseResult<String> updateInfo(@RequestBody UserInfoRequest userInfoRequest){
        String userId = userInfoService.updateInfo(userInfoRequest);
        return Response.makeOKResponse(userId);
    }

    //注销用户
    @PostMapping("/logout")
    public ResponseResult<String> logoutInfo(@RequestBody UserInfoRequest userInfoRequest){
        String userId = userInfoService.updateInfo(userInfoRequest);
        return Response.makeOKResponse(userId);
    }

    //用户列表
    @PostMapping("/queryAllInfo")
    public ResponseResult<List<UserInfo>> queryAllInfo(@RequestBody String userId){
        List<UserInfo> userInfoList = userInfoService.queryAllInfo(userId);
        return Response.makeOKResponse(userInfoList);
    }

    //删除用户



}

