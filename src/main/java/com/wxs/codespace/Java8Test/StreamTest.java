package com.wxs.codespace.Java8Test;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args){
        List<String> nameList = Lists.newArrayList("wxs", "bdm");
        nameList = nameList.stream()
                .filter(name -> name.length()>0)
                .map(name -> "Super_" + name)
                .collect(Collectors.toList());
        System.out.println(nameList);
    }
}

