package com.rleon.examplekafkaP01.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
public class MessageProducer {

    public void sendMessage() {
        long startTime = System.currentTimeMillis();
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); /* broker de kafka al que nos vamos a conectar **/
        props.put("acks", "all");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("linger.ms", "org.apache.kafka.common.serialization.StringSerializer");

        try (Producer<String, String> producer = new KafkaProducer<>(props)) {
            for (int i = 0; i < 1000000; i++) {
                producer.send(new ProducerRecord<>("leon-topic-1", String.valueOf(i),
                        "leon-value-mensaje de prueba: " + i));
                //  .get(); // con el get se vuelve sincrono y el performance es afectado
            }
            producer.flush();
        }
        log.info("Processing time = {} ms", (System.currentTimeMillis() - startTime));
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//            log.error("Error-->", e);
//        }

    }
}
