package com.hobby.strategy_pattern.enum_strategy;

import com.hobby.payment.interfaces.Payment;

/**
 * 枚举策略模式
 *
 * @author Harris
 */
public enum PaymentTypeEnum {

    /**
     * 支付宝
     */
    ALI_PAY(PaymentStrategyProvider::aliPay),
    /**
     * 微信
     */
    WX_PAY(PaymentStrategyProvider::weChatPay),
    ;

    private final Payment payment;

    PaymentTypeEnum(Payment  payment){
        this.payment = payment;
    }

    public Double pay(Double amount){
        return payment.pay(amount);
    }

}
