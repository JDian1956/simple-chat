package com.hobby.strategy_pattern.enum_strategy;

/**
 * @author Harris
 */
public class EnumStrategyPatternDemo {
    public static void main(String[] args) {
        Double alipay = PaymentTypeEnum.ALI_PAY.pay(100D);
        System.out.println(alipay);
        Double wechatPay = PaymentTypeEnum.WX_PAY.pay(100D);
        System.out.println(wechatPay);

        PaymentTypeEnum aliPay = PaymentTypeEnum.valueOf(PaymentTypeEnum.ALI_PAY.name());
        System.out.println(aliPay.pay(100D));
    }
}
