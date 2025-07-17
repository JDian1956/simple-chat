package com.hobby.payment;

import com.hobby.payment.interfaces.Payment;

/**
 * @author Harris
 */
public class BankCardPayment implements Payment {
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
