package com.wxs.codespace;

import java.math.BigDecimal;

public class Whatever {
    private enum EnumTest{
        RED(10), YELLOW(13);
        private int value;

        EnumTest(int i) {
            value = i;
        }
    }
    public static void main(String[] args){
        int a = 1;
        switch (a){
            case 1:{
                System.out.println(1);
                System.out.println(1);
                System.out.println(1);
                System.out.println(3);
            }
        }
        System.out.println(new BigDecimal(10.0).subtract(new BigDecimal(0.1)));
        double d = 10.0d;
        double d1 = 0.1d;
        System.out.println(d-d1);
    }
}
