package com.hobby.auth.dto;

import lombok.Data;

/**
 * @author Harris
 */
@Data
public class SysUserDto{
    private Long userId;
    private String userName;
    private String nickName;
    private String userType;
    private String sex;
    private String phone;
    private String email;
    private String avatar;
    private String status;
    private String delFlag;
    private String remark;
}
