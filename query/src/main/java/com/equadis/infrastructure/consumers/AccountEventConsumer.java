package com.equadis.infrastructure.consumers;

import com.equadis.events.AccountOpenedEvent;
import com.equadis.events.BaseEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class AccountEventConsumer {
    @KafkaListener(topics = "AccountOpenedEvent", groupId = "bankaccConsumer", containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload AccountOpenedEvent event) {
        System.out.println("Event is: " + event);
    }
}
