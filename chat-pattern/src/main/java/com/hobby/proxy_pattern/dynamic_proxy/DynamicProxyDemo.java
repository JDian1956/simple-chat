package com.hobby.proxy_pattern.dynamic_proxy;

import com.hobby.proxy_pattern.MakePayment;
import com.hobby.proxy_pattern.MakePaymentImpl;

import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @author Harris
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        MakePayment makePayment = new MakePaymentImpl();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(makePayment);

        ClassLoader classLoader = makePayment.getClass().getClassLoader();
        Class<?>[] interfaces = makePayment.getClass().getInterfaces();
        MakePayment proxyInstance = (MakePayment)Proxy.newProxyInstance(classLoader, interfaces, dynamicProxyHandler);

        proxyInstance.makePayment();

        // 打印类加载器的详细信息
        System.out.println("ClassLoader: " + classLoader);
        System.out.println("ClassLoader class: " + classLoader.getClass().getName());

        // 打印接口数组中的每个接口
        System.out.println("Interfaces count: " + interfaces.length);
        for (Class<?> intf : interfaces) {
            System.out.println("Interface: " + intf.getName());
        }


        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
