package com.poc.kafka_poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChuvaService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public ChuvaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void publicarEvento(String mensagem) {
        kafkaTemplate.send("chuva.detectada", mensagem);
    }
}
