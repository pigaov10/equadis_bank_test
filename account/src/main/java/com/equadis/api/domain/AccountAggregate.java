package com.equadis.api.domain;

import com.equadis.api.commands.OpenAccountCommand;
import com.equadis.domain.AggregateRoot;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AccountAggregate extends AggregateRoot {

    public void openAccount(OpenAccountCommand command) {

    }

    public void depositFunds(double amount) {

    }

    public void withdrawFunds(double amount) {
    }
}
