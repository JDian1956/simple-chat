package com.hobby.factory_pattern;

/**
 * @author Harris
 */
public interface IPay {
    /**
     * 支付
     * @param price 金额
     * @return 金额
     */
    Double pay(Double price);
}
