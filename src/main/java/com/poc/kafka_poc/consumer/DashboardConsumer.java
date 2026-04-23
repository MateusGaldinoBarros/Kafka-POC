package com.poc.kafka_poc.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DashboardConsumer {

    @KafkaListener(topics = "chuva.detectada", groupId = "grupo-Dashboard")
    public void consumir(String mensagem) {
        System.out.println("Dashboard: "+mensagem);
    }
}
