package com.hobby.factory_pattern.simple_factory;

import com.hobby.factory_pattern.AliPay;
import com.hobby.factory_pattern.BankCardPay;
import com.hobby.factory_pattern.IPay;
import com.hobby.factory_pattern.WeChatPay;

/**
 * 简单工厂模式
 *
 * @author Harris
 */
public class PayFactory {
    public static IPay pay(String payType) {
        return switch (payType) {
            case "ali" -> new AliPay();
            case "wechat" -> new WeChatPay();
            case "bankcard" -> new BankCardPay();
            default -> throw new RuntimeException("暂不支持的支付类型");
        };
    }
}
