package com.number47.train.design.singleton;

/**
 * 饿汉模式,线程安全
 * @author number47
 * @date 2022/1/17 14:38
 * @description
 */
public class HungryMan {
    private static HungryMan instance = new HungryMan();
    private HungryMan () {
        System.out.println(Thread.currentThread().getName() + "\t" + "HungryMan构造方法创建");
    }
    public static HungryMan getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                HungryMan.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
