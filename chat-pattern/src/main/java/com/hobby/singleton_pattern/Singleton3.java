package com.hobby.singleton_pattern;

/**
 * 懒汉模式，线程安全
 * <p>在getInstance()方法上增加了synchronized锁，可以实现只有一个线程进行实例化对象，
 * 但是instance已经被实例化过，还是只能有一个线程访问getInstance()方法，性能急剧下降。</p>
 *
 * @author Harris
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {

    }

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
