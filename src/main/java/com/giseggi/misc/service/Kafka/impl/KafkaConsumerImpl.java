package com.giseggi.misc.service.Kafka.impl;

import com.giseggi.misc.service.Kafka.KafkaConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerImpl implements KafkaConsumer {

    @Override
    @KafkaListener(topics = "kafka-demo", groupId = "kafka-demo")
    public void consume(String message) {
        log.info("Consumed message {}", message);
    }
}
