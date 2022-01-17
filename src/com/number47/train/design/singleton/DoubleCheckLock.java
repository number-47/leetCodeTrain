package com.number47.train.design.singleton;

/**
 * 双重校验锁
 * @author number47
 * @date 2022/1/17 14:57
 * @description
 */
public class DoubleCheckLock {
    private volatile static DoubleCheckLock singleton;
    private DoubleCheckLock () {
        System.out.println(Thread.currentThread().getName() + "\t" + "DoubleCheckLock构造方法创建");
    }
    public static DoubleCheckLock getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheckLock.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckLock();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                DoubleCheckLock.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
