package com.hobby.factory_pattern;


/**
 * @author Harris
 */
public class WeChatPay implements IPay {
    /**
     * 支付
     *
     * @param price 金额
     * @return 金额
     */
    @Override
    public Double pay(Double price) {
        System.out.println("使用微信支付");
        return price * 10;
    }
}
