package com.equadis.infrastructure.domain;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<BankAccount, String> {
}
