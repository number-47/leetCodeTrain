package com.number47.train.design.abstractfactory;

import com.number47.train.design.abstractfactory.family.BlueShapeFactory;
import com.number47.train.design.abstractfactory.family.RedShapeFactory;
import com.number47.train.design.abstractfactory.family.ShapeFactory;
import com.number47.train.design.abstractfactory.level.Shape;

/**
 * 增加新的族很方便， 无须修改已有系统， 符合“开闭原则”。
 * 增加新的等级结构麻烦， 需要对原有系统进行较大的修改， 甚至需要修改抽象层代码
 * @author number47
 * @date 2022/1/18 15:57
 * @description
 */
public class TestDemo {
    public static void main(String[] args) {
        ShapeFactory redShapeFactory = new RedShapeFactory();
        Shape circle = redShapeFactory.getCircle();
        circle.draw();
        Shape rectangle = redShapeFactory.getRectangle();
        rectangle.draw();

        ShapeFactory blueShapeFactory = new BlueShapeFactory();
        Shape blueCircle = blueShapeFactory.getCircle();
        blueCircle.draw();
    }
}
