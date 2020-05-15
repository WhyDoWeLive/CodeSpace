package com.wxs.codespace.RPCTest.DubboTest.provider;

import com.wxs.codespace.RPCTest.DubboTest.ServiceInterfaces.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
