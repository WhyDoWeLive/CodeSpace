package com.wxs.codespace.KafkaTest.SimpleSpringKafkaTest;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyConsumer {
    @KafkaListener(topics = "wxsFirstTopic")
    public void send(ConsumerRecord<?, ?> record){
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()){
            Object message = kafkaMessage.get();
            System.out.println("receive message: " + message);
        }
    }
}
