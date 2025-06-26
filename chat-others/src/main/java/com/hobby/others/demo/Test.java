package com.hobby.others.demo;

import com.hobby.others.demo.domain.UserBO;
import com.hobby.others.demo.domain.UserDTO;

/**
 * @author Harris
 */
public class Test {

    public static void main(String[] args) {
        UserBO userBo = new UserBO();
        userBo.setUsername("harris");
        userBo.setPassword("123456");
        userBo.setPhone("12345678901");
        UserDTO userDto = UserConvert.INSTANCE.userBoToUserDto(userBo);
        System.out.println(userDto.toString());
    }
}
