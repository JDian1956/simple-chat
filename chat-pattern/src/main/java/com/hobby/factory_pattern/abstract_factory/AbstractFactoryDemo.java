package com.hobby.factory_pattern.abstract_factory;

import com.hobby.factory_pattern.abstract_factory.company.AppleCompanyProducer;
import com.hobby.factory_pattern.abstract_factory.company.DellCompanyProducer;
import com.hobby.factory_pattern.abstract_factory.company.MiCompanyProducer;
import com.hobby.factory_pattern.abstract_factory.factory.CompanyFactory;
import com.hobby.factory_pattern.abstract_factory.factory.ComputerFactory;
import com.hobby.factory_pattern.abstract_factory.factory.PhoneFactory;

/**
 * @author Harris
 */
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        CompanyFactory appleCompany = new AppleCompanyProducer();
        ComputerFactory appleComputer = appleCompany.createComputerFactory();
        PhoneFactory applePhone = appleCompany.createPhoneFactory();

        appleComputer.createComputer();
        applePhone.createPhone();

        CompanyFactory dellCompanyFactory = new DellCompanyProducer();
        ComputerFactory dellComputerFactory = dellCompanyFactory.createComputerFactory();
        PhoneFactory dellPhoneFactory = dellCompanyFactory.createPhoneFactory();

        dellComputerFactory.createComputer();
        dellPhoneFactory.createPhone();

        CompanyFactory miCompanyFactory = new MiCompanyProducer();
        ComputerFactory miComputerFactory = miCompanyFactory.createComputerFactory();
        PhoneFactory miPhoneFactory = miCompanyFactory.createPhoneFactory();

        miComputerFactory.createComputer();
        miPhoneFactory.createPhone();

    }
}
