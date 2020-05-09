package com.wxs.codespace.ThreadTest;

public class StackOverFlowTest extends Thread{
    public static int depth = 0;
    public static void recursive(){
        depth++;
        recursive();
    }



    public static void triggerStackOverFlow(){
        try {
            recursive();
        }catch (Exception e){
            System.out.println(depth);
        }finally {
            System.out.println(depth);
        }
    }

    public static void triggerOutOfMemory(){
        try {
            triggerStackOverFlow();
        }catch (Exception e){
        }finally {
            System.out.println(depth);
        }
    }

    public static void main(String[] args){
        triggerOutOfMemory();
    }


}
