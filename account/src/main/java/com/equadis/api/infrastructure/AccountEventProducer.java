package com.equadis.api.infrastructure;

import com.equadis.events.BaseEvent;
import com.equadis.producers.EventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountEventProducer implements EventProducer {

    @Autowired
    private KafkaTemplate<String, BaseEvent> kafkaTemplate;

    @Override
    public void produce(String topic, BaseEvent message) {
        this.kafkaTemplate.send(topic, message);
    }
}
