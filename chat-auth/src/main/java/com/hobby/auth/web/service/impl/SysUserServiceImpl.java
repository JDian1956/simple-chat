package com.hobby.auth.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hobby.auth.web.mapper.SysUserMapper;
import com.hobby.auth.web.pojo.SysUser;
import com.hobby.auth.web.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Harris
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private final SysUserMapper userMapper;

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return SysUser
     */
    @Override
    public SysUser queryByUsername(String username) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUserName, username);
        return userMapper.selectOne(wrapper);
    }
}
