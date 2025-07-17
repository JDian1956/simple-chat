package com.hobby.strategy_pattern.strategy1;

/**
 * 基本策略模式
 *
 * @author Harris
 */
public interface Strategy {

    /**
     * 支付
     * @param price
     * @return
     */
    Double pay(Double price);
}
