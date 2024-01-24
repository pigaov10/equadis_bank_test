package com.equadis.producers;


import com.equadis.events.BaseEvent;

public interface EventProducer {
    void produce(String topic, BaseEvent message);
}
