package com.wxs.codespace.APITest;

public class StringTest {
    public static void main(String[] args){
        String commissionRate = "0.1%";
        String standardCommissionRate = commissionRate.trim().replaceAll("%", "");
        System.out.println(standardCommissionRate);

        /**
         * StringBuilder
         */
        StringBuilder stringBuilder = new StringBuilder("method=");
        stringBuilder.append("\'").append("add\'");
        System.out.println(stringBuilder);
    }

}
