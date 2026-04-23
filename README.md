# Kafka POC — Estudo de Mensageria com Apache Kafka

## O que é este projeto

POC (Proof of Concept) desenvolvida para estudar o Apache Kafka na prática, 
simulando um cenário de monitoramento climático com múltiplos consumidores independentes.

## Por que Kafka?

O RabbitMQ entrega uma mensagem para um único consumidor — ela some da fila após ser lida.
O Kafka persiste a mensagem no topic e permite que múltiplos consumidores independentes 
a leiam no seu próprio ritmo, cada um controlando sua posição de leitura (offset).

## O que foi implementado

- **Producer**: endpoint `POST /chuva` que publica eventos no topic `chuva.detectada`
- **3 Consumers independentes**: `AlertaConsumer`, `PersistenciaConsumer` e `DashboardConsumer`
- Cada consumer pertence a um consumer group diferente, garantindo leitura independente
- Configuração do ambiente com Docker Compose (Kafka + Zookeeper)

## Como rodar

**Pré-requisitos**: Java 21, Docker

```bash
# Subir o Kafka
cd kafka-poc
docker compose up -d

# Rodar a aplicação
./gradlew bootRun
```

Publicar um evento via POST em `http://localhost:8080/chuva` com body em texto.

## O que observar

Ao derrubar um consumer e publicar mensagens enquanto ele está fora, 
ao subir novamente ele recupera todas as mensagens pendentes pelo offset — 
sem perda de dados, sem intervenção manual.

## Stack

Java 21 · Spring Boot 3 · Apache Kafka · Docker Compose
