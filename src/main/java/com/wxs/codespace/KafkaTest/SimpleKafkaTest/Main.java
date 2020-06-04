package com.wxs.codespace.KafkaTest.SimpleKafkaTest;

/**
 * 首先要启动Zookeeper：zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties
 * 然后启动Kafka：kafka-server-start /usr/local/etc/kafka/server.properties
 */
public class Main {
    public static void main(String[] args) {
        WxsProducer pro = new WxsProducer(KafkaConfig.KafkaProperties.TOPIC);
        pro.start();

        WxsConsumer con = new WxsConsumer(KafkaConfig.KafkaProperties.TOPIC);
        con.start();
    }
}
