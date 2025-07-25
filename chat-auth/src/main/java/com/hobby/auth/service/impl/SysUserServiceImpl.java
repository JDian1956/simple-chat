package com.hobby.auth.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hobby.api.RemoteNotifyService;
import com.hobby.api.entity.AccountEntity;
import com.hobby.auth.convertor.UserConvertor;
import com.hobby.auth.dto.SysUserDto;
import com.hobby.auth.mapper.SysUserMapper;
import com.hobby.auth.entity.SysUser;
import com.hobby.auth.service.SysUserService;
import com.hobby.datasource.utils.PageResponse;
import lombok.RequiredArgsConstructor;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Harris
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements SysUserService {

    private final SysUserMapper userMapper;
    private final RemoteNotifyService remoteNotifyService;

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

    @GlobalTransactional(rollbackFor = Exception.class, timeoutMills = 30000)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer registerUser(SysUser sysUser) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUserId(sysUser.getUserName());
        accountEntity.setMoney(1000L);
        remoteNotifyService.addNotify(accountEntity);

        userMapper.insert(sysUser);
        return 1;
    }

    @SentinelResource(value = "queryAuthList")
    @Override
    public PageResponse<SysUserDto> queryList(int current, int size) {
        if ( current < 1 || size < 1){
            return null;
        }
        Page<SysUser> objectPage = new Page<>(current, size);
        Page<SysUser> pages = userMapper.selectPage(objectPage, null);

        return PageResponse.of(pages, UserConvertor.INSTANCE.toDTO(pages.getRecords()));
    }
}
