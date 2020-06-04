package com.wxs.codespace;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Whatever2{
    public static void main(String[] args) throws ParseException {
        Optional<?> optional = Optional.of("hello");
        if (!optional.isPresent()){
            System.out.println("optional is null");
        }
        else {
            System.out.println(optional.get());
        }
    }
}
