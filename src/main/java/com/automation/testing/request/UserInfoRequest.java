package com.automation.testing.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoRequest implements Serializable {

    private String userId;
    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户状态(0:注销 1:正常)
     */
    private Integer userStatus;

    /**
     * 用户身份证
     */
    private String userIdCardNo;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 用户住址
     */
    private String userAddress;

}
