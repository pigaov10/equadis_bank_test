package com.equadis.infrastructure;

public interface EventStore {
    void saveEvents(String aggregateId, int expectedVersion);
}
