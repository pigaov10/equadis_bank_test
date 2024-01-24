package com.equadis.infrastructure.consumers;

import com.equadis.events.AccountOpenedEvent;
import com.equadis.events.BaseEvent;
import com.equadis.events.FundsDepositedEvent;
import com.equadis.events.FundsWithdrawnEvent;
import com.equadis.infrastructure.handlers.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class AccountEventConsumer {

    @Autowired
    private EventHandler eventHandler;

    @KafkaListener(topics = "AccountOpenedEvent", groupId = "bankaccConsumer", containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload AccountOpenedEvent event) {
        System.out.println("Event is: " + event);
    }

    @KafkaListener(topics = "FundsWithdrawnEvent", groupId = "bankaccConsumer", containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload FundsWithdrawnEvent event) {
        System.out.println("Event is: " + event);
    }

    @KafkaListener(topics = "FundsDepositedEvent", groupId = "bankaccConsumer", containerFactory = "kafkaListenerContainerFactory")
    public void consume(@Payload FundsDepositedEvent event) {
        System.out.println("Event is: " + event);
    }
}
