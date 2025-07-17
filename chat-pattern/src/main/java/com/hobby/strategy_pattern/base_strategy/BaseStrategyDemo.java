package com.hobby.strategy_pattern.base_strategy;

/**
 * @author Harris
 */
public class BaseStrategyDemo {
    public static void main(String[] args) {
        Double zfb = new PaymentStrategy("zfb").pay(100.0);
        System.out.println(zfb);
        Double wx = new PaymentStrategy("weChat").pay(100.0);
        System.out.println(wx);
    }
}
