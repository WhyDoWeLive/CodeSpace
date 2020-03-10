package com.wxs.codespace.RPCTest.SimpleRPCImpl.Consumer;

import com.wxs.codespace.RPCTest.SimpleRPCImpl.Provider.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerApp {
    private static Logger log = LoggerFactory.getLogger(ConsumerApp.class);

    public static void main(String[] args){
        Calculator calculator = new CalculatorRemoteProxy();
        log.info("calculate result {}: ", calculator.add(1, 19));
    }
}
