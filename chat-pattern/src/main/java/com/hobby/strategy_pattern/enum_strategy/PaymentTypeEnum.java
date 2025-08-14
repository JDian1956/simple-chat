package com.hobby.strategy_pattern.enum_strategy;

/**
 * 枚举策略模式
 *
 * @author Harris
 */
public enum PaymentTypeEnum {

    /**
     * 支付宝
     */
    ALI_PAY{
        public Double apply(Double price) {
            System.out.println("使用支付宝支付");
            return price * 0.1;
        }
    },
    /**
     * 微信
     */
    WX_PAY {
        public Double apply(Double price) {
            System.out.println("使用微信支付");
            return price * 0.01;
        }
    },
    ;

    public abstract Double apply(Double amount);

}
