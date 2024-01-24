package com.equadis.api.infrastructure;

import com.equadis.api.domain.AccountAggregate;
import com.equadis.api.domain.BankAccountEventModel;
import com.equadis.api.domain.BankAccountEventStoreRepository;
import com.equadis.events.BaseEvent;
import com.equadis.infrastructure.EventStore;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class AccountEventStore implements EventStore {

    private final BankAccountEventStoreRepository bankAccountEventStoreRepository;

    public AccountEventStore(BankAccountEventStoreRepository bankAccountEventRepository) {
        this.bankAccountEventStoreRepository = bankAccountEventRepository;
    }
    @Override
    public void saveEvents(String aggregateId, BaseEvent event, int expectedVersion) {
        bankAccountEventStoreRepository.save(BankAccountEventModel.builder()
                .id(UUID.randomUUID().toString())
                .timeStamp(new Date())
                .aggregateIdentifier(aggregateId)
                .aggregateType(AccountAggregate.class.getTypeName())
                .eventType(event.toString())
                .build());
    }
}
