package com.wxs.codespace.KafkaTest.SimpleKafkaTest;

public class Main {
    public static void main(String[] args) {
        WxsProducer pro = new WxsProducer(KafkaConfig.KafkaProperties.TOPIC);
        pro.start();

        WxsConsumer con = new WxsConsumer(KafkaConfig.KafkaProperties.TOPIC);
        con.start();
    }
}
