package com.equadis.infrastructure;

import com.equadis.events.BaseEvent;

public interface EventStore {
    void saveEvents(String aggregateId, BaseEvent event, int expectedVersion);
}
