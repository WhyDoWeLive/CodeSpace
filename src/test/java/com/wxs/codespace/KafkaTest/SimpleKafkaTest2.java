package com.wxs.codespace.KafkaTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.wxs.codespace.KafkaTest.SimpleSpringKafkaTest.MyProducer;

@SpringBootTest
public class SimpleKafkaTest2 {
    @Autowired
    public MyProducer myProducer;

    @Test
    public void testKafka(){
        myProducer.send();
    }
}
