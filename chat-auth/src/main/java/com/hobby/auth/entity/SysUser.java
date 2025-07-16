package com.hobby.auth.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.hobby.datasource.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Harris
 */
@EqualsAndHashCode(callSuper = false)
@Data
@TableName("sys_user")
public class SysUser extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long userId;
    private String userName;
    private String nickName;
    private String password;
    private String userType;
    private String sex;
    private String phone;
    private String email;
    private String avatar;
    private String status;

    @TableLogic
    private String delFlag;
    private String remark;

}
