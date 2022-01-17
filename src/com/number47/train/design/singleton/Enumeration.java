package com.number47.train.design.singleton;

/**
 * 枚举方式创建单例模式，线程安全
 * @author number47
 * @date 2022/1/17 14:53
 * @description
 */
public enum Enumeration {
    INSTANCE;
    public void whateverMethod() {
    }
    private Enumeration(){
        System.out.println(Thread.currentThread().getName() + "\t" + "Enumeration构造方法创建");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                Enumeration.INSTANCE.whateverMethod();
            }, String.valueOf(i)).start();
        }
    }
}
