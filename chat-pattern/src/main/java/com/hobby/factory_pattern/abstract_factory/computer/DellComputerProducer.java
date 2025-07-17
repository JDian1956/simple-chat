package com.hobby.factory_pattern.abstract_factory.computer;

import com.hobby.factory_pattern.abstract_factory.factory.ComputerFactory;

/**
 * @author Harris
 */
public class DellComputerProducer implements ComputerFactory {
    /**
     * 创建电脑
     */
    @Override
    public void createComputer() {
        System.out.println("创建戴尔电脑工厂");
    }
}
