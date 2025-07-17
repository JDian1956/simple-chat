package com.hobby.singleton_pattern;

/**
 * 双重检查锁模式，线程安全
 * <p>instance对象用了volatile修饰，会禁止jvm对该对象的指令重排序，保证线程安全</p>
 *
 * @author Harris
 */
public class Singleton5 {

    private static volatile Singleton5 instance;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
