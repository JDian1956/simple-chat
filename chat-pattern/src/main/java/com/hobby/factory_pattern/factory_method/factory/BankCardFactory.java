package com.hobby.factory_pattern.factory_method.factory;

import com.hobby.factory_pattern.factory_method.factory.interfaces.PaymentFactory;
import com.hobby.payment.BankCardPayment;
import com.hobby.payment.interfaces.Payment;

/**
 * @author Harris
 */
public class BankCardFactory implements PaymentFactory {
    /**
     * 创建支付
     *
     * @return 支付
     */
    @Override
    public Payment createPay() {
        return new BankCardPayment();
    }
}
