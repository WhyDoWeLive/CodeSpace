package com.wxs.codespace.KafkaTest.SimpleSpringKafkaTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyProducer {
    @Autowired
    public KafkaTemplate<String, String> kafkaTemplate;

    public void send(){
        kafkaTemplate.send("wxsFirstTopic", "hello, this is wxs's first msg");
    }
}
