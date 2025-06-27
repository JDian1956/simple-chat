package com.hobby.notify.service;

import com.hobby.notify.entity.AccountEntity;
import com.hobby.notify.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.apache.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Harris
 */
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountMapper accountMapper;

    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public int insert(AccountEntity entity) {
        return accountMapper.insert(entity);
    }

    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public int deleteById(Long id) {
        return accountMapper.deleteById(id);
    }

    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public int updateById(AccountEntity entity) {
        return accountMapper.updateById(entity);
    }
}
