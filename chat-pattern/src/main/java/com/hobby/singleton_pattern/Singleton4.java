package com.hobby.singleton_pattern;

/**
 * 双重检查锁定实现的单例模式（非线程安全）
 *
 * <p>虽然通过两次检查 {@code instance == null} 来减少同步开销，
 * 并确保最多只会有一个线程创建实例，但由于 JVM 的指令重排序机制，
 * 仍然存在线程安全问题。</p>
 *
 * <p>{@code instance = new Singleton4();} 实际上包含以下三个步骤：</p>
 * <ol>
 *   <li>在堆上为对象分配内存空间</li>
 *   <li>调用构造函数，初始化对象</li>
 *   <li>将引用变量指向堆中的内存地址</li>
 * </ol>
 *
 * <p>在多线程环境下，JVM 可能对第 2 和第 3 步进行重排序优化。
 * 如果某个线程看到的是尚未完全初始化的对象引用，就会导致返回一个未初始化完成的实例，
 * 在后续使用该实例时可能抛出空指针异常（NPE）。</p>
 *
 * <p>修复方式：给声明添加 {@code volatile} 关键字。</p>
 *
 * @author Harris
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
