package com.wxs.codespace.KafkaTest.SimpleKafkaTest;
import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * @Date May 22, 2015
 *
 * @Author dengjie
 *
 * @Note Kafka WxsProducer
 */
public class WxsProducer extends Thread {

    private Producer<Integer, String> producer;
    private String topic;
    private Properties props = new Properties();
    private final int SLEEP = 1000 * 3;

    /**
     * 由构造函数可见，生产者需要知道broker的ip:port列表、topic、序列化方式
     * @param topic
     */
    public WxsProducer(String topic) {
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "127.0.0.1:9092");
        producer = new Producer<>(new ProducerConfig(props));
        this.topic = topic;
    }

    @Override
    public void run() {
        int offsetNo = 1;
        while (true) {
            String msg = "Message_" + offsetNo;
            System.out.println("Send->[" + msg + "]");
            producer.send(new KeyedMessage<>(topic, msg));
            offsetNo++;
            try {
                sleep(SLEEP);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}