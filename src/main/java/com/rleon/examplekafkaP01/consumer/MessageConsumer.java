package com.rleon.examplekafkaP01.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

@Slf4j
public class MessageConsumer {


    public void readMessage() {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "leon-group");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        try (KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props)) {
            kafkaConsumer.subscribe(Arrays.asList("leon-topic-1"));

            while (true) {
                ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                    log.info("Offset = {}, Partition = {}, Key={}, Value = {} ",
                            consumerRecord.offset(), consumerRecord.partition(), consumerRecord.key(), consumerRecord.value());
                }
            }
        }

    }
}
