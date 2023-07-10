package com.newer.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class MyConsumer {
    @StreamListener(Sink.INPUT)
    public void receiver(String message) {
        System.out.println("接收到MQ消息:" + message);
    }
}