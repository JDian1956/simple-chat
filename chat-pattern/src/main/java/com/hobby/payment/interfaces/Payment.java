package com.hobby.payment.interfaces;

/**
 * @author Harris
 */
public interface Payment {
    /**
     * 支付
     * @param price 金额
     * @return 金额
     */
    Double pay(Double price);
}
