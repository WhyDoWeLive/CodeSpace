package com.wxs.codespace.DesignPattern.Factory.AbstractFactory;

public class FactoryB extends Factory {
    @Override
    public Fruit manufactureApple() {
        return new AppleB();
    }

    @Override
    public Fruit manufactureBanana() {
        return new BananaB();
    }
}
