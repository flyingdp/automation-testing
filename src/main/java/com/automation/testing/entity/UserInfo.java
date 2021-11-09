package com.automation.testing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author flying
 * @since 2021-11-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user_info")
public class UserInfo extends Model {

    /**
     * 用户id
     */
//    @TableId(value = "user_id")
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

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 删除标志(0:已删  1:未删-默认)
     */
    private Integer is_delete;

}
