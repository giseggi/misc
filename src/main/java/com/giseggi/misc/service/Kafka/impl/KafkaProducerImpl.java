package com.giseggi.misc.service.Kafka.impl;

import com.giseggi.misc.service.Kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerImpl implements KafkaProducer {

    private static final String TOPIC = "kafka-demo";

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        log.debug("Produce message: {}", message);
        kafkaTemplate.send(TOPIC, message);
    }
}
