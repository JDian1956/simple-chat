package com.hobby.strategy_pattern.strategy1;

/**
 * @author Harris
 */
public class WeChatPay implements  Strategy{
    /**
     * 支付
     *
     * @param price
     * @return
     */
    @Override
    public Double pay(Double price) {
        System.out.println("微信支付");
        return price*2;
    }
}
