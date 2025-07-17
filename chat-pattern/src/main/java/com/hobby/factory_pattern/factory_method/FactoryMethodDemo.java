package com.hobby.factory_pattern.factory_method;

import com.hobby.factory_pattern.factory_method.factory.interfaces.PaymentFactory;
import com.hobby.factory_pattern.factory_method.factory.AliPayFactory;
import com.hobby.factory_pattern.factory_method.factory.BankCardFactory;
import com.hobby.factory_pattern.factory_method.factory.WeChatFactory;

/**
 * @author Harris
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        PaymentFactory aliPaymentFactory = new AliPayFactory();
        Double aliPay = aliPaymentFactory.createPay().pay(100.0);
        System.out.println(aliPay);

        PaymentFactory weChatPaymentFactory = new WeChatFactory();
        Double weChatPay = weChatPaymentFactory.createPay().pay(100.0);
        System.out.println(weChatPay);

        PaymentFactory bankCardPaymentFactory = new BankCardFactory();
        Double bankCardPay = bankCardPaymentFactory.createPay().pay(100.0);
        System.out.println(bankCardPay);
    }
}
