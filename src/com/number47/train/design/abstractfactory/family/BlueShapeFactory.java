package com.number47.train.design.abstractfactory.family;

import com.number47.train.design.abstractfactory.level.Shape;
import com.number47.train.design.abstractfactory.level.circle.BlueCircle;
import com.number47.train.design.abstractfactory.level.circle.RedCircle;
import com.number47.train.design.abstractfactory.level.rectangle.BlueRectangle;
import com.number47.train.design.abstractfactory.level.rectangle.RedRectangle;

/**
 * 具体工厂BlueShapeFactory
 * @author number47
 * @date 2022/1/18 15:55
 * @description
 */
public class BlueShapeFactory implements ShapeFactory{
    @Override
    public Shape getCircle() {
        return new BlueCircle();
    }

    @Override
    public Shape getRectangle() {
        return new BlueRectangle();
    }
}
