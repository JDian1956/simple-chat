package com.hobby.strategy_pattern.strategy1;

/**
 * @author Harris
 */
public class AliPay implements  Strategy{
    /**
     * 支付
     *
     * @param price
     * @return
     */
    @Override
    public Double pay(Double price) {
        System.out.println("使用支付宝支付");
        return price;
    }
}
