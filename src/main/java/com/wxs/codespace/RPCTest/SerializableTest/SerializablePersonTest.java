package com.wxs.codespace.RPCTest.SerializableTest;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.*;

@AllArgsConstructor
@Setter
public class SerializablePersonTest implements Externalizable {
    private static final long serialVersionUID = 11114013L;
    int age;
    String namee;
    String sex;
    Dog dog;

    public SerializablePersonTest(){}

//    private Object writeReplace(){
//        return 23;
//    }
//
//    private Object readResolve(){
//        return 24;
//    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.namee);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.namee = (String) objectInputStream.readObject();
    }


    @Override
    public String toString(){
        return "person{ namee: " + namee + ", age : " + age + "}";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(namee);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.namee = (String) in.readObject();
    }

    @AllArgsConstructor
    public static class Dog implements Serializable{
        String name;
    }

    public static void main(String[] args){
        try {
            //将对象序列化至磁盘
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.txt"));
            SerializablePersonTest personTest = new SerializablePersonTest(29, "wxs","d", new Dog("wangcai"));
            objectOutputStream.writeObject(personTest);
            personTest.setNamee("bdm");
            objectOutputStream.writeObject(personTest);

            //将对象从磁盘反序列化至内存，反序列化时，没有调用构造函数，反序列化的对象是由JVM自己生成的对象
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.txt"));
            SerializablePersonTest i = (SerializablePersonTest) objectInputStream.readObject();
//            System.out.println(readedPerson);
//            readedPerson = (SerializablePersonTest) objectInputStream.readObject();
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
