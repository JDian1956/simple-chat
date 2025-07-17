package com.hobby.factory_pattern.abstract_factory.factory;

/**
 * @author Harris
 */
public interface CompanyFactory {

    /**
     * 创建计算机工厂
     * @return factory
     */
    default ComputerFactory createComputerFactory(){
        throw new UnsupportedOperationException();
    };

    /**
     * 创建手机工厂
     * @return factory
     */
    default PhoneFactory createPhoneFactory(){
        throw new UnsupportedOperationException();
    };
}
