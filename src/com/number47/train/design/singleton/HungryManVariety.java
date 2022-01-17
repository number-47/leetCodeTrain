package com.number47.train.design.singleton;

/**
 * 饿汉模式变种,线程安全
 * @author number47
 * @date 2022/1/17 14:38
 * @description
 */
public class HungryManVariety {
    private static HungryManVariety instance = new HungryManVariety();
    private HungryManVariety() {
        System.out.println(Thread.currentThread().getName() + "\t" + "HungryManVariety构造方法创建");
    }
    public static HungryManVariety getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                HungryManVariety.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
