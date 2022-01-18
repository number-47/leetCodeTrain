package com.number47.train.design.abstractfactory.family;

import com.number47.train.design.abstractfactory.level.Shape;

/**
 * 抽象工厂ShapeFactory
 * @author number47
 * @date 2022/1/18 14:34
 * @description 抽象工厂ShapeFactory
 * 声明一组用于创建一族产品的方法，每个方法对应一种对象；
 * 在抽象工厂中声明了多个工厂方法， 
 * 用于创建不同类型的对象， 抽象工厂可以是接口， 也可以是抽象类或者具体类
 */
public interface ShapeFactory  {
    Shape getCircle();
    Shape getRectangle();
}
