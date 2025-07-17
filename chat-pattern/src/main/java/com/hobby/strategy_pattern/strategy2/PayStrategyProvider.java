package com.hobby.strategy_pattern.strategy2;

/**
 * @author Harris
 */
public class PayStrategyProvider {

    public static Double aliPay(Double price) {
        System.out.println("使用支付宝支付");
        return price * 0.1;
    }

    public static Double weChatPay(Double price) {
        System.out.println("使用微信支付");
        return price * 0.01;
    }
}
