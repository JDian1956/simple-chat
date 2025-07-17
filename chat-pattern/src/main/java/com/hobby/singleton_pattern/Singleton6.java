package com.hobby.singleton_pattern;

/**
 * 使用静态内部类实现的单例模式。
 *
 * <p>该实现方式具有以下优势：</p>
 * <ul>
 *   <li>懒加载：仅在首次调用 {@link #getInstance()} 时初始化</li>
 *   <li>线程安全：由 JVM 类加载机制保障</li>
 *   <li>高性能：无需加锁或同步操作</li>
 * </ul>
 *
 * <p>推荐用于大多数需要单例的场景。</p>
 *
 * @author Harris
 */
public class Singleton6 {
    private static class SingletonHolder {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
