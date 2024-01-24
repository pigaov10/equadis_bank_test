package com.equadis.api.domain;

import com.equadis.api.commands.OpenAccountCommand;
import com.equadis.domain.AggregateRoot;
import com.equadis.events.AccountOpenedEvent;
import com.equadis.events.FundsDepositedEvent;
import com.equadis.events.FundsWithdrawnEvent;
import com.equadis.infrastructure.AccountType;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountAggregate extends AggregateRoot {
    public AccountAggregate(OpenAccountCommand command) {
        System.out.println(AccountOpenedEvent.builder()
                .accountType(AccountType.CHECKING_ACCOUNT.name())
                .build());
    }

    public void depositFunds(double amount) {
        System.out.println(FundsDepositedEvent.builder().amount(amount).build());
    }

    public void withdrawFunds(double amount) {
        System.out.println(FundsWithdrawnEvent.builder().amount(amount).build());
    }
}
