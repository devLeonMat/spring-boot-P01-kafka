package com.rleon.examplekafkaP01;

import com.rleon.examplekafkaP01.consumer.MessageConsumer;
import com.rleon.examplekafkaP01.producer.MessageProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleKafkaP01Application {

    public static void main(String[] args) {
        SpringApplication.run(ExampleKafkaP01Application.class, args);

        // Producer
//        MessageProducer messageProducer = new MessageProducer();
//        messageProducer.sendMessage();
//
        // Consumer
        MessageConsumer messageConsumer = new MessageConsumer();
        messageConsumer.readMessage();
    }

}
