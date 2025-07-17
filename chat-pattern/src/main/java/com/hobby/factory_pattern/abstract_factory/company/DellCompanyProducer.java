package com.hobby.factory_pattern.abstract_factory.company;

import com.hobby.factory_pattern.abstract_factory.computer.DellComputerProducer;
import com.hobby.factory_pattern.abstract_factory.phone.DellPhoneProducer;
import com.hobby.factory_pattern.abstract_factory.factory.CompanyFactory;
import com.hobby.factory_pattern.abstract_factory.factory.ComputerFactory;
import com.hobby.factory_pattern.abstract_factory.factory.PhoneFactory;

/**
 * @author Harris
 */
public class DellCompanyProducer implements CompanyFactory {
    /**
     * 创建计算机工厂
     *
     * @return factory
     */
    @Override
    public ComputerFactory createComputerFactory() {
        return new DellComputerProducer();
    }

    /**
     * 创建手机工厂
     *
     * @return factory
     */
    @Override
    public PhoneFactory createPhoneFactory() {
        return new DellPhoneProducer();
    }
}
