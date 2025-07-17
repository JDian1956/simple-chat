package com.hobby.strategy_pattern.strategy2;

/**
 * @author Harris
 */
public class Main2 {
    public static void main(String[] args) {
        Double alipay = PaymentStrategyEnum.ALI_PAY.pay(100D);
        System.out.println(alipay);
        Double wechatPay = PaymentStrategyEnum.WX_PAY.pay(100D);
        System.out.println(wechatPay);

        PaymentStrategyEnum aliPay = PaymentStrategyEnum.valueOf(PaymentStrategyEnum.ALI_PAY.name());
        System.out.println(aliPay.pay(100D));
    }
}
