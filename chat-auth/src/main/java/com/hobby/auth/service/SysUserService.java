package com.hobby.auth.service;

import com.hobby.auth.dto.SysUserDto;
import com.hobby.auth.entity.SysUser;
import com.hobby.datasource.utils.PageResponse;

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

    Integer registerUser(SysUser sysUser);

    PageResponse<SysUserDto> queryList(int current, int size);
}
