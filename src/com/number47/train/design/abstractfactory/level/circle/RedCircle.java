package com.number47.train.design.abstractfactory.level.circle;

import com.number47.train.design.abstractfactory.level.Circle;
import com.number47.train.design.abstractfactory.level.Shape;

/**
 * @author number47
 * @date 2022/1/18 14:13
 * @description
 */
public class RedCircle extends Circle {
    @Override
    public void draw() {
        System.out.println("绘制红色的圆");
    }
}
