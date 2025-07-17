package com.hobby.payment;


import com.hobby.payment.interfaces.Payment;

/**
 * @author Harris
 */
public class WeChatPayment implements Payment {
    /**
     * 支付
     *
     * @param price
     * @return
     */
    @Override
    public Double pay(Double price) {
        System.out.println("微信支付");
        return price * 10;
    }
}
