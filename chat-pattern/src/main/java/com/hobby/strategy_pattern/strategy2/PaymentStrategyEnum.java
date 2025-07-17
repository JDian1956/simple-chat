package com.hobby.strategy_pattern.strategy2;

import com.hobby.strategy_pattern.strategy1.Strategy;

/**
 * 枚举策略模式
 *
 * @author Harris
 */
public enum PaymentStrategyEnum {

    /**
     * 支付宝
     */
    ALI_PAY(PayStrategyProvider::aliPay),
    /**
     * 微信
     */
    WX_PAY(PayStrategyProvider::weChatPay),
    ;

    private final Strategy strategy;

    PaymentStrategyEnum(Strategy  strategy){
        this.strategy = strategy;
    }

    public Double pay(Double amount){
        return strategy.pay(amount);
    }

}
