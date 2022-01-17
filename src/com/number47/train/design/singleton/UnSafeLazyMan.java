package com.number47.train.design.singleton;

/**
 * 懒汉，线程不安全
 * @author number47
 * @date 2022/1/17 13:38
 * @description 懒汉，线程不安全
 */
public class UnSafeLazyMan {
    private static UnSafeLazyMan instance;
    private UnSafeLazyMan(){
        System.out.println(Thread.currentThread().getName() + "\t" + "UnSafeLazyMan构造方法创建"+ "\t" + instance);
    }

    public static UnSafeLazyMan getInstance(){
        if (instance == null) {
            instance = new UnSafeLazyMan();
        }
        return instance;
    }

    public static void main(String[] args) {
        //每次执行会出现不同的结果，打印构造函数的语句次数每次都不同
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                UnSafeLazyMan.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
