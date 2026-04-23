package com.poc.kafka_poc.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PersistenciaConsumer {

    @KafkaListener(topics = "chuva.detectada",groupId = "grupo-Persistencia")
    public void consumir (String mensagem) {
        System.out.println("Persistencia: "+mensagem);
    }
}
