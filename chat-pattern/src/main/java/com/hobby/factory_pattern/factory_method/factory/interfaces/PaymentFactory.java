package com.hobby.factory_pattern.factory_method.factory.interfaces;

import com.hobby.payment.interfaces.Payment;

/**
 * @author Harris
 */
public interface PaymentFactory {
    /**
     * 创建支付
     *
     * @return 支付
     */
    Payment createPay();
}
