package com.hobby.strategy_pattern.base_strategy;

import com.hobby.payment.AliPayment;
import com.hobby.payment.WeChatPayment;
import com.hobby.payment.interfaces.Payment;

/**
 * @author Harris
 */
public class PaymentStrategy {

    private Payment payment;

    /**
     * 构造函数，传入具体的策略对象
     * @param type
     */
    public PaymentStrategy(String  type)
    {
        if ("weChat".equals(type)){
            payment = new WeChatPayment();
        }
        if ("zfb".equals(type)){
            payment = new AliPayment();
        }
    }

    /**
     * 调用策略对象中的算法
     * @param price
     * @return
     */
    public Double pay(Double price)
    {
        return payment.pay(price);
    }

}
