package com.number47.train.design.abstractfactory.level.rectangle;

import com.number47.train.design.abstractfactory.level.Rectangle;

/**
 * @author number47
 * @date 2022/1/18 14:11
 * @description
 */
public class RedRectangle extends Rectangle {
    @Override
    public void draw() {
        System.out.println("绘制红色长方形");
    }
}
