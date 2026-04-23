package com.poc.kafka_poc.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class AlertaConsumer {

    @KafkaListener(topics = "chuva.detectada", groupId = "grupo-alerta")
    public void consumir(String mensagem) {
        System.out.println("Alerta: "+mensagem);
    }


}
