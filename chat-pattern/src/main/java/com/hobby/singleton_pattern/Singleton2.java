package com.hobby.singleton_pattern;

/**
 * 懒汉模式，非线程安全
 * <p>
 * 虽然代码判断了当instance不等于空时，才进行初始化。
 * 但是当多个线程同时执行到if(instance==null)的时候，
 * 一个线程执行完new Singleton()，其他线程也会接着执行，导致new出多个实例。
 * </p>
 *
 * @author Harris
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
