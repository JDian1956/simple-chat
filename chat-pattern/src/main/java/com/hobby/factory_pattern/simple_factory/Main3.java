package com.hobby.factory_pattern.simple_factory;

import com.hobby.factory_pattern.IPay;

/**
 * @author Harris
 */
public class Main3 {
    public static void main(String[] args) {
        IPay pay = PayFactory.pay("ali");
        System.out.println(pay.pay(100D));

        IPay pay1 = PayFactory.pay("wechat");
        System.out.println(pay1.pay(100D));

        IPay pay2 = PayFactory.pay("bankcard");
        System.out.println(pay2.pay(100D));
    }
}
