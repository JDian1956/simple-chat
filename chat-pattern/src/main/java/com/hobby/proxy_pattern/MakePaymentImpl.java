package com.hobby.proxy_pattern;

import com.hobby.proxy_pattern.MakePayment;

/**
 * @author Harris
 */
public class MakePaymentImpl implements MakePayment {
    @Override
    public void makePayment() {
        System.out.println("正在付款中...");
    }
}
