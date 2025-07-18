package com.hobby.proxy_pattern.dynamic_proxy;

import com.hobby.proxy_pattern.MakePayment;
import com.hobby.proxy_pattern.MakePaymentImpl;

import java.lang.reflect.Proxy;

/**
 * @author Harris
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        MakePayment makePayment = new MakePaymentImpl();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(makePayment);

        MakePayment proxyInstance = (MakePayment)Proxy.newProxyInstance(
                makePayment.getClass().getClassLoader(),
                makePayment.getClass().getInterfaces(),
                dynamicProxyHandler
        );

        proxyInstance.makePayment();
    }
}
