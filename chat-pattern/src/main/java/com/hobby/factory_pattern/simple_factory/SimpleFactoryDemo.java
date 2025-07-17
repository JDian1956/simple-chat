package com.hobby.factory_pattern.simple_factory;

import com.hobby.payment.interfaces.Payment;

/**
 * @author Harris
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        Payment payment = PaymentFactory.createFactory("ali");
        System.out.println(payment.pay(100D));

        Payment payment1 = PaymentFactory.createFactory("wechat");
        System.out.println(payment1.pay(100D));

        Payment payment2 = PaymentFactory.createFactory("bankcard");
        System.out.println(payment2.pay(100D));
    }
}
