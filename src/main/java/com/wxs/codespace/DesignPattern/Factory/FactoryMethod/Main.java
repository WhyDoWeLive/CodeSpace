package com.wxs.codespace.DesignPattern.Factory.FactoryMethod;

public class Main {
    public static void main(String[] args){
        AppleFactory appleFactory = new AppleFactory();
        appleFactory.Manufacture().printName();

        BananaFactory bananaFactory = new BananaFactory();
        bananaFactory.Manufacture().printName();
    }
}
