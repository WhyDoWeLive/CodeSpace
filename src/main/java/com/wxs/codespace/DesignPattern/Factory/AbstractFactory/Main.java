package com.wxs.codespace.DesignPattern.Factory.AbstractFactory;

public class Main {
    public static void main(String[] args){
        FactoryA factoryA = new FactoryA();
        FactoryB factoryB = new FactoryB();

        factoryA.manufactureApple().printName();
        factoryA.manufactureBanana().printName();

        factoryB.manufactureApple().printName();
        factoryB.manufactureBanana().printName();
    }
}
