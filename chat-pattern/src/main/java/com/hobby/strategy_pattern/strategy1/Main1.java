package com.hobby.strategy_pattern.strategy1;

/**
 * @author Harris
 */
public class Main1 {
    public static void main(String[] args) {
        Double zfb = new Payment("zfb").pay(100.0);
        System.out.println(zfb);
        Double wx = new Payment("wx").pay(100.0);
        System.out.println(wx);
    }
}
