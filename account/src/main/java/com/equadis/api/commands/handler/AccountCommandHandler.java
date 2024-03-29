package com.equadis.api.commands.handler;

import com.equadis.api.commands.DepositFundsCommand;
import com.equadis.api.commands.OpenAccountCommand;
import com.equadis.api.commands.WithdrawFundsCommand;
import com.equadis.api.domain.AccountAggregate;
import com.equadis.events.AccountOpenedEvent;
import com.equadis.events.BaseEvent;
import com.equadis.events.FundsDepositedEvent;
import com.equadis.events.FundsWithdrawnEvent;
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
        var aggregate = new AccountAggregate();
        AccountOpenedEvent event = new AccountOpenedEvent(aggregate.getId(), AccountType.CHECKING_ACCOUNT.name(), command.getInitialBalance());
        eventStore.saveEvents(aggregate.getId(), event, -1);
        eventProducer.produce("AccountOpenedEvent", event);
    }

    @Override
    public void handle(WithdrawFundsCommand command) {
        if (command.getAmount() > 100)
            throw new IllegalStateException("Withdrawal declined, insufficient funds! cannot be negative");

        var aggregate = new AccountAggregate();
        aggregate.withdrawFunds(command.getAmount());
        FundsWithdrawnEvent event = new FundsWithdrawnEvent(command.getAmount());
        eventStore.saveEvents(aggregate.getId(), event, -1);
        eventProducer.produce("FundsWithdrawnEvent", event);
    }

    @Override
    public void handle(DepositFundsCommand command) {
        var aggregate = new AccountAggregate();
        FundsDepositedEvent event = new FundsDepositedEvent(command.getAmount());
        aggregate.withdrawFunds(command.getAmount());
        eventStore.saveEvents(aggregate.getId(), event, -1);
        eventProducer.produce("FundsDepositedEvent", event);
    }
}
