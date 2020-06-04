package com.wxs.codespace.DesignPattern.Factory.AbstractFactory;

public class FactoryA extends Factory {
    @Override
    public Fruit manufactureApple() {
        return new AppleA();
    }

    @Override
    public Fruit manufactureBanana() {
        return new BananaA();
    }
}
