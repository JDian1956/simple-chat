package com.hobby.factory_pattern.abstract_factory.phone;

import com.hobby.factory_pattern.abstract_factory.factory.PhoneFactory;

/**
 * @author Harris
 */
public class MiPhoneProducer implements PhoneFactory {
    /**
     * 创建手机
     */
    @Override
    public void createPhone() {
        System.out.println("创建小米手机工厂");
    }
}
