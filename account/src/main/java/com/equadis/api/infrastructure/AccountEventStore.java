package com.equadis.api.infrastructure;

import com.equadis.api.domain.AccountAggregate;
import com.equadis.api.domain.BankAccountEventModel;
import com.equadis.api.domain.BankAccountEventStoreRepository;
import com.equadis.infrastructure.EventStore;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountEventStore implements EventStore {

    private final BankAccountEventStoreRepository bankAccountEventStoreRepository;

    public AccountEventStore(BankAccountEventStoreRepository bankAccountEventRepository) {
        this.bankAccountEventStoreRepository = bankAccountEventRepository;
    }

    @Override
    public void saveEvents(String aggregateId, int expectedVersion) {
        bankAccountEventStoreRepository.save(BankAccountEventModel.builder()
                .timeStamp(new Date())
                .aggregateIdentifier(aggregateId)
                .aggregateType(AccountAggregate.class.getTypeName())
                .build());
    }
}
