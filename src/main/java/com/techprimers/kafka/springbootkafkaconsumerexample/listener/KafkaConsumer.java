package com.techprimers.kafka.springbootkafkaconsumerexample.listener;

import com.techprimers.kafka.springbootkafkaconsumerexample.StatementServiceImpl;
import com.techprimers.kafka.springbootkafkaconsumerexample.model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @Autowired
    private StatementServiceImpl service;

    @KafkaListener(topics = "Kafka_Example", group = "group_id")
    public void consume(String message) {
        service.save1();
        System.out.println("Consumed message: " + message);
    }


    @KafkaListener(topics = "Kafka_Example_json", group = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(Statement statement) {
        service.save();
        System.out.println("Consumed JSON Message: " + statement);
    }
}
