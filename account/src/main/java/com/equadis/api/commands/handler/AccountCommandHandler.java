package com.equadis.api.commands.handler;

import com.equadis.api.commands.OpenAccountCommand;
import com.equadis.api.domain.AccountAggregate;
import com.equadis.events.AccountOpenedEvent;
import com.equadis.events.BaseEvent;
import com.equadis.infrastructure.AccountType;
import com.equadis.infrastructure.EventStore;
import com.equadis.producers.EventProducer;
import org.springframework.stereotype.Service;

@Service
public class AccountCommandHandler implements CommandHandler {

    private final EventStore eventStore;
    private final EventProducer eventProducer;

    public AccountCommandHandler(EventStore eventStore, EventProducer eventProducer) {
        this.eventStore = eventStore;
        this.eventProducer = eventProducer;
    }

    @Override
    public void handle(OpenAccountCommand command) {
        var aggregate = new AccountAggregate(command);
        eventStore.saveEvents("raphael", -1);
        BaseEvent event = AccountOpenedEvent.builder().accountType(AccountType.CHECKING_ACCOUNT.name()).build();
        eventProducer.produce("AccountOpenedEvent", event);
        var a = 1;
    }
}
