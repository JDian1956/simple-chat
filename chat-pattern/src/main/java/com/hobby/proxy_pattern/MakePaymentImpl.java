package com.hobby.proxy_pattern;


/**
 * @author Harris
 */
public class MakePaymentImpl implements MakePayment {
    @Override
    public void makePayment() {
        System.out.println("正在付款中...");
    }
}
