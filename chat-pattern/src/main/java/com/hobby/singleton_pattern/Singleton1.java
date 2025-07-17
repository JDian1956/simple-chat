package com.hobby.singleton_pattern;

/**
 * 饿汉模式
 * <p>优点是线程安全的，只有一个实例。缺点是即使没有调用getInstance()方法，instance实例在类加载时被初始化了。</p>
 *
 * @author Harris
 */
public class Singleton1 {
    private static final Singleton1 SINGLETON = new Singleton1();

    /**
     * 私有构造函数, 防止被new
     */
    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return SINGLETON;
    }
}
