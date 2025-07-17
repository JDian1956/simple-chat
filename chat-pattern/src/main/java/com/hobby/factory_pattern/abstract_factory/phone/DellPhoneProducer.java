package com.hobby.factory_pattern.abstract_factory.phone;

import com.hobby.factory_pattern.abstract_factory.factory.PhoneFactory;

/**
 * @author Harris
 */
public class DellPhoneProducer implements PhoneFactory {
    /**
     * 创建手机
     */
    @Override
    public void createPhone() {
        System.out.println("创建戴尔手机工厂");
    }
}
