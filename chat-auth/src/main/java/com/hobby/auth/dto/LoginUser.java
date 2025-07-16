package com.hobby.auth.dto;

import com.hobby.auth.entity.SysUser;
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
