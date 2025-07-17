package com.hobby.factory_pattern;

import com.hobby.factory_pattern.IPay;

/**
 * @author Harris
 */
public class BankCardPay implements IPay {
    /**
     * 支付
     *
     * @param price 金额
     * @return 金额
     */
    @Override
    public Double pay(Double price) {
        System.out.println("使用银行卡支付");
        return price * 0.1;
    }
}
