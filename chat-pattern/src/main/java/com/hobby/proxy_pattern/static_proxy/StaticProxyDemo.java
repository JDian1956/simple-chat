package com.hobby.proxy_pattern.static_proxy;


import com.hobby.proxy_pattern.MakePayment;
import com.hobby.proxy_pattern.MakePaymentImpl;

/**
 * @author Harris
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        MakePayment payment = new MakePaymentImpl();
        MakePaymentProxy makePaymentProxy = new MakePaymentProxy(payment);
        makePaymentProxy.makePayment();
    }
}
