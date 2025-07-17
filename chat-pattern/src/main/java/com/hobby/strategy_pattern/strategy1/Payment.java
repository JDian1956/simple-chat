package com.hobby.strategy_pattern.strategy1;

/**
 * @author Harris
 */
public class Payment {

    private Strategy strategy;

    /**
     * 构造函数，传入具体的策略对象
     * @param type
     */
    public Payment(String  type)
    {
        if ("wx".equals(type)){
            strategy = new WeChatPay();
        }
        if ("zfb".equals(type)){
            strategy = new AliPay();
        }
    }

    /**
     * 调用策略对象中的算法
     * @param price
     * @return
     */
    public Double pay(Double price)
    {
        return strategy.pay(price);
    }

}
