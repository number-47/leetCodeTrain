package com.number47.train.design.singleton;

/**
 *  懒汉，线程安全
 * @author number47
 * @date 2022/1/17 13:38
 * @description 懒汉，线程安全
 */
public class SafeLazyMan {
    private static SafeLazyMan instance;
    private SafeLazyMan(){
        System.out.println(Thread.currentThread().getName() + "\t" + "SafeLazyMan构造方法创建");
    }
    public static synchronized SafeLazyMan getInstance(){
        if (instance == null) {
            instance = new SafeLazyMan();
        }
        return instance;
    }

    
    public static void main(String[] args) {
        //每次执行只会打印一次语句
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SafeLazyMan.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
