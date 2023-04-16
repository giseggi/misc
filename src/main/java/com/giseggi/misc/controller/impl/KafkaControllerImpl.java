package com.giseggi.misc.controller.impl;

import com.giseggi.misc.controller.KafkaController;
import com.giseggi.misc.service.Kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class KafkaControllerImpl implements KafkaController {

    private final KafkaProducer producer;

    @Override
    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam("message") String message) {
        try {
            producer.sendMessage(message);
            return "success";
        } catch(Exception e) {
            return "error occurred :(";
        }
    }
}
