package com.wxs.codespace.GenericTest;

import java.util.ArrayList;

/**
 * 输出泛型参数T的Class
 * @param <T>
 */
public class GenericClass<T> implements GenericInterface<String>{
    @Override
    public void printHello(String i) {

    }

    public static void main(String[] args){
        GenericClass<String> stringGenericClass = new GenericClass<>();
        GenericClass<Integer> integerGenericClass = new GenericClass<>();

        stringGenericClass.printClass("wxs");
        integerGenericClass.printClass(3);

        //类泛型参数是String，调用的泛型方法的类型参数是Integer
        stringGenericClass.printGenericClass(1);

        //java泛型擦除：运行时传入的参数都被丢掉了
        Class<?> c1 = new ArrayList<String>().getClass();
        Class<?> c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1.equals(c2));
    }

    //非泛型方法，只不过参数是类型参数
    public void printClass(T t){
        System.out.println(t.getClass());
    }

    //泛型方法，E与T想独立，即使把<E>改成<T>，也是如此
    private <E> void printGenericClass(E e){
        System.out.println(e.getClass());
    }
}
