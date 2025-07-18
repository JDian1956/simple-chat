package com.hobby.proxy_pattern.static_proxy;


import com.hobby.proxy_pattern.MakePayment;

/**
 * @author Harris
 */
public class MakePaymentProxy implements MakePayment {

    private final MakePayment payment;

    public MakePaymentProxy(final MakePayment payment) {
        this.payment = payment;
    }

    @Override
    public void makePayment() {
        System.out.println("开始支付...");
        payment.makePayment();
        System.out.println("支付完成...");
    }
}
