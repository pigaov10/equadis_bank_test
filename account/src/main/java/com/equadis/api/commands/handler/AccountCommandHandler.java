package com.equadis.api.commands.handler;

import com.equadis.api.commands.OpenAccountCommand;
import com.equadis.api.domain.AccountAggregate;
import com.equadis.events.AccountOpenedEvent;
import com.equadis.infrastructure.AccountType;
import org.springframework.stereotype.Service;

@Service
public class AccountCommandHandler implements CommandHandler {



    @Override
    public void handle(OpenAccountCommand command) {
        var aggregate = new AccountAggregate(command);

    }
}
