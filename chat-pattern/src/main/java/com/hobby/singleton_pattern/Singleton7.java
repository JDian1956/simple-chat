package com.hobby.singleton_pattern;

/**
 * 枚举单例
 * <p>线程安全，唯一</p>
 *
 * @author Harris
 */
public enum Singleton7 {

    /**
     * 单例对象
     */
    INSTANCE,
    ;

    public static void main(String[] args) {
        Singleton7 singleton7 = Singleton7.INSTANCE;
    }
}