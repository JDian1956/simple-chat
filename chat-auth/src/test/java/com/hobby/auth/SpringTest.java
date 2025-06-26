package com.hobby.auth;

import com.hobby.auth.web.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Harris
 */
@SpringBootTest
public class SpringTest {

    @Autowired
    private  SysUserService sysUserService;

    @Test
    public void test1(){
        sysUserService.queryByUsername("admin");
    }

}
