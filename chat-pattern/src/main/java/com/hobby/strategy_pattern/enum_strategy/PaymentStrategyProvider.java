package com.hobby.strategy_pattern.enum_strategy;

/**
 * @author Harris
 */
public class PaymentStrategyProvider {

    public static Double aliPay(Double price) {
        System.out.println("使用支付宝支付");
        return price * 0.1;
    }

    public static Double weChatPay(Double price) {
        System.out.println("使用微信支付");
        return price * 0.01;
    }
}
