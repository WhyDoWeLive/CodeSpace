package com.wxs.codespace.KafkaTest.SimpleKafkaTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

/**
 * @Date May 22, 2015
 *
 * @Author dengjie
 *
 * @Note Kafka Consumer
 */
public class WxsConsumer extends Thread {

    private ConsumerConnector consumer;
    private String topic;
    private final int SLEEP = 1000 * 3;

    /**
     * 由构造函数可看出：消费者需要知道topic、zk的ip:host
     * @param topic
     */
    public WxsConsumer(String topic) {
        consumer = Consumer.createJavaConsumerConnector(this.consumerConfig());
        this.topic = topic;
    }

    private ConsumerConfig consumerConfig() {
        Properties props = new Properties();
        //指定zookeeper连接字符串， 格式如hostname:port/chroot。chroot是一个namespace
        props.put("zookeeper.connect", KafkaConfig.KafkaProperties.ZK);

        //一个字符串用来指示一组consumer所在的组
        props.put("group.id", KafkaConfig.KafkaProperties.GROUP_ID);

        //连接zk的session超时时间
        props.put("zookeeper.session.timeout.ms", "40000");

        //zk follower落后于zk leader的最长时间
        props.put("zookeeper.sync.time.ms", "200");

        //往zookeeper上写offset的频率
        props.put("auto.commit.interval.ms", "1000");
        return new ConsumerConfig(props);
    }

    @Override
    public void run() {
        Map<String, Integer> topicCountMap = new HashMap<>();
        topicCountMap.put(topic, 1);
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = consumerMap.get(topic).get(0);
        ConsumerIterator<byte[], byte[]> it = stream.iterator();
        while (it.hasNext()) {
            System.out.println("Receive->[" + new String(it.next().message()) + "]");
            try {
                sleep(SLEEP);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
