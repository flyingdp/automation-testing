package com.automation.testing.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class UserInfoRsponse implements Serializable {

    private String userId;
    /**
     * 用户姓名
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userName;

    /**
     * 用户状态(0:注销 1:正常)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer userStatus;

    /**
     * 用户身份证
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userIdCardNo;

    /**
     * 用户年龄
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer userAge;

    /**
     * 用户住址
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String userAddress;

    /**
     * 创建时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp createTime;

    /**
     * 更新时间
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp updateTime;

}
