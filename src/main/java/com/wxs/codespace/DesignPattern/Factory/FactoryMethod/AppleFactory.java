package com.wxs.codespace.DesignPattern.Factory.FactoryMethod;

import com.wxs.codespace.DesignPattern.Factory.SimpleFactory.Apple;
import com.wxs.codespace.DesignPattern.Factory.SimpleFactory.Fruit;

public class AppleFactory extends FruitFactory {
    @Override
    public Fruit Manufacture() {
        return new Apple();
    }
}
