package com.hobby.auth.web.service;

import com.hobby.auth.web.pojo.SysUser;

/**
 * @author Harris
 */
public interface SysUserService {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return SysUser
     */
    SysUser queryByUsername(String username);
}
