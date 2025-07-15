package com.hobby.auth.entity;

import com.hobby.auth.web.pojo.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Harris
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser{
    private SysUser user;
}
