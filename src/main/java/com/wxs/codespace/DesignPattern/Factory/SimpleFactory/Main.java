package com.wxs.codespace.DesignPattern.Factory.SimpleFactory;

public class Main {
    public static void main(String[] args) {
        FruitFactory.manufacture("apple").printName();
        FruitFactory.manufacture("banana").printName();
    }
}
