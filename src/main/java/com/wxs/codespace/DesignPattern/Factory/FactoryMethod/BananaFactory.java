package com.wxs.codespace.DesignPattern.Factory.FactoryMethod;

import com.wxs.codespace.DesignPattern.Factory.SimpleFactory.Banana;
import com.wxs.codespace.DesignPattern.Factory.SimpleFactory.Fruit;

public class BananaFactory extends FruitFactory {
    @Override
    public Fruit Manufacture() {
        return new Banana();
    }
}
