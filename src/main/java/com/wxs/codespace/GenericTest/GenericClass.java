package com.wxs.codespace.GenericTest;

/**
 * 输出泛型参数T的Class
 * @param <T>
 */
public class GenericClass<T> {
    public static void main(String[] args){
        GenericClass<String> stringGenericClass = new GenericClass<>();
        GenericClass<Integer> integerGenericClass = new GenericClass<>();

        stringGenericClass.printClass("wxs");
        integerGenericClass.printClass(3);
    }

    public void printClass(T t){
        System.out.println(t.getClass());
    }
}
