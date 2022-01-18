package com.number47.train.design.abstractfactory.family;

import com.number47.train.design.abstractfactory.level.Shape;
import com.number47.train.design.abstractfactory.level.circle.RedCircle;
import com.number47.train.design.abstractfactory.level.rectangle.RedRectangle;

/**
 * 具体工厂RedShapeFactory
 * @author number47
 * @date 2022/1/18 15:55
 * @description
 * 具体工厂实现了抽象工厂，
 * 每个工厂方法返回一个具体对象，
 * 一个具体工厂所创建的具体对象构成一个族
 */
public class RedShapeFactory implements ShapeFactory{
    @Override
    public Shape getCircle() {
        return new RedCircle();
    }

    @Override
    public Shape getRectangle() {
        return new RedRectangle();
    }
}
