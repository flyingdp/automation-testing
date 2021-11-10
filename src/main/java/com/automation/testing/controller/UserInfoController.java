package com.automation.testing.controller;


import com.automation.testing.entity.UserInfo;
import com.automation.testing.request.UserInfoRequest;
import com.automation.testing.response.Response;
import com.automation.testing.response.ResponseResult;
import com.automation.testing.response.ResultCode;
import com.automation.testing.response.UserInfoRsponse;
import com.automation.testing.service.IUserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


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
        if (userInfoRequest.getUserIdCardNo() == null){
            return Response.makeErrResponse("用户ID不能为空");
        }
        String userId = userInfoService.addInfo(userInfoRequest);
        UserInfoRsponse userInfoRsponse = new UserInfoRsponse();
        userInfoRsponse.setUserId(userId);
        return Response.makeOKResponse(userInfoRsponse);
    }

    //查询用户-query
    @PostMapping("/query")
    public ResponseResult<UserInfoRsponse> queryInfo(@RequestBody UserInfoRequest userInfoRequest){
        if (userInfoRequest.getUserId() == null){
            return Response.makeErrResponse("用户ID不能为空");
        }
        UserInfo userInfo = userInfoService.queryInfo(userInfoRequest.getUserId());
        UserInfoRsponse userInfoRsponse = new UserInfoRsponse();
        BeanUtils.copyProperties(userInfo,userInfoRsponse);
        return Response.makeOKResponse(userInfoRsponse);
    }

    //修改用户信息-edit
    @PostMapping("/edit")
    public ResponseResult<UserInfoRsponse> updateInfo(@RequestBody UserInfoRequest userInfoRequest){
        if (userInfoRequest.getUserId() == null){
            return Response.makeErrResponse("用户ID不能为空");
        }
        String userId = userInfoService.updateInfo(userInfoRequest);
        UserInfoRsponse userInfoRsponse = new UserInfoRsponse();
        userInfoRsponse.setUserId(userId);
        return Response.makeOKResponse(userInfoRsponse);
    }

    //注销用户
    @PostMapping("/logout")
    public ResponseResult<UserInfoRsponse> logoutInfo(@RequestBody UserInfoRequest userInfoRequest){
        if (userInfoRequest.getUserId() == null){
            return Response.makeErrResponse("用户ID不能为空");
        }
        UserInfo userInfo = userInfoService.logoutUserByUserId(userInfoRequest);

        UserInfoRsponse userInfoRsponse = new UserInfoRsponse();
        BeanUtils.copyProperties(userInfo,userInfoRsponse);
        return Response.makeOKResponse(userInfoRsponse);
    }

    //用户列表
    @PostMapping("/queryAllInfo")
    public ResponseResult<List<UserInfoRsponse>> queryAllInfo(){
        List<UserInfo> userInfoList = userInfoService.queryAllInfo();
        List<UserInfoRsponse> listResponse = new ArrayList<>();
        for (UserInfo userInfo: userInfoList) {
            UserInfoRsponse userInfoRsponse = new UserInfoRsponse();
            BeanUtils.copyProperties(userInfo,userInfoRsponse);
            listResponse.add(userInfoRsponse);
        }
        return Response.makeOKResponse(listResponse);
    }

}

