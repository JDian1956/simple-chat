package com.hobby.auth.service;

import com.hobby.auth.entity.LoginUser;
import com.hobby.auth.web.pojo.SysUser;
import com.hobby.auth.web.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Harris
 */

@Configuration
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.queryByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new LoginUser(sysUser, null);
    }
}
