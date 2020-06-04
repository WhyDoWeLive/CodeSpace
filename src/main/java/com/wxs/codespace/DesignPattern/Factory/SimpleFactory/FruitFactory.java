package com.wxs.codespace.DesignPattern.Factory.SimpleFactory;

public class FruitFactory {
    public static Fruit manufacture(String fruitName){
        switch (fruitName){
            case "apple":
                return new Apple();
            case "banana":
                return new Banana();
            case "orange":
                return new Orange();
            default :
                return null;
        }
    }
}
