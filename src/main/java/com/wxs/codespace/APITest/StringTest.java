package com.wxs.codespace.APITest;

public class StringTest {
    public static void main(String[] args){
        String commissionRate = "0.1%";
        String standardCommissionRate = commissionRate.trim().replaceAll("%", "");
        System.out.println(standardCommissionRate);
    }

}
