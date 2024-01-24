package com.equadis.api.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountEventStoreRepository extends MongoRepository<BankAccountEventModel, String> {
}
