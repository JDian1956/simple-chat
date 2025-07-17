package com.hobby.factory_pattern.factory_method.factory;

import com.hobby.factory_pattern.factory_method.factory.interfaces.PaymentFactory;
import com.hobby.payment.AliPayment;
import com.hobby.payment.interfaces.Payment;

/**
 * @author Harris
 */
public class AliPayFactory implements PaymentFactory {
    @Override
    public Payment createPay() {
        return new AliPayment();
    }
}
