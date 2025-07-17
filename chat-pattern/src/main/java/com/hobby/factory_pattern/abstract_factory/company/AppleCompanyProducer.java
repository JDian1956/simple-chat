package com.hobby.factory_pattern.abstract_factory.company;

import com.hobby.factory_pattern.abstract_factory.computer.AppleComputerProducer;
import com.hobby.factory_pattern.abstract_factory.phone.ApplePhoneProducer;
import com.hobby.factory_pattern.abstract_factory.factory.CompanyFactory;
import com.hobby.factory_pattern.abstract_factory.factory.ComputerFactory;
import com.hobby.factory_pattern.abstract_factory.factory.PhoneFactory;

/**
 * @author Harris
 */
public class AppleCompanyProducer implements CompanyFactory {
    /**
     * 创建计算机工厂
     *
     * @return factory
     */
    @Override
    public ComputerFactory createComputerFactory() {
        return new AppleComputerProducer();
    }

    /**
     * 创建手机工厂
     *
     * @return factory
     */
    @Override
    public PhoneFactory createPhoneFactory() {
        return new ApplePhoneProducer();
    }
}
