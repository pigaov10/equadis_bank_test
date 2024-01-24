package com.equadis.api.domain;

import com.equadis.api.commands.OpenAccountCommand;
import com.equadis.domain.AggregateRoot;
import com.equadis.events.AccountOpenedEvent;
import com.equadis.infrastructure.AccountType;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountAggregate extends AggregateRoot {
    public AccountAggregate(OpenAccountCommand command) {
        System.out.println(AccountOpenedEvent.builder()
                .accountType(AccountType.CHECKING_ACCOUNT.name())
                .build());
    }
}
