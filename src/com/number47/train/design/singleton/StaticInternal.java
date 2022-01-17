package com.number47.train.design.singleton;

/**
 * 静态内部类，线程安全
 * @author number47
 * @date 2022/1/17 14:49
 * @description
 */
public class StaticInternal {
    private static class SingletonHolder {
        private static final StaticInternal INSTANCE = new StaticInternal();
    }
    private StaticInternal() {
        System.out.println(Thread.currentThread().getName() + "\t" + "StaticInternal构造方法创建");
    }
    public static final StaticInternal getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                StaticInternal.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
