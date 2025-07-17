package com.hobby.factory_pattern.simple_factory;

import com.hobby.payment.AliPayment;
import com.hobby.payment.BankCardPayment;
import com.hobby.payment.WeChatPayment;
import com.hobby.payment.interfaces.Payment;

/**
 * 简单工厂模式
 *
 * @author Harris
 */
public class PaymentFactory {
    public static Payment createFactory(String payType) {
        return switch (payType) {
            case "ali" -> new AliPayment();
            case "wechat" -> new WeChatPayment();
            case "bankcard" -> new BankCardPayment();
            default -> throw new RuntimeException("暂不支持的支付类型");
        };
    }
}
