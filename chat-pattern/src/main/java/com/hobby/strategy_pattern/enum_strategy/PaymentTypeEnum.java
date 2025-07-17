package com.hobby.strategy_pattern.enum_strategy;

import com.hobby.strategy_pattern.base_strategy.Strategy;

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

    private final Strategy strategy;

    PaymentTypeEnum(Strategy  strategy){
        this.strategy = strategy;
    }

    public Double pay(Double amount){
        return strategy.pay(amount);
    }

}
