package com.hobby.payment;


import com.hobby.payment.interfaces.Payment;

/**
 * @author Harris
 */
public class AliPayment implements Payment {
    /**
     * 支付
     *
     * @param price
     * @return
     */
    @Override
    public Double pay(Double price) {
        System.out.println("使用支付宝支付");
        return price * 100;
    }
}
