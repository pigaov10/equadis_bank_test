package com.equadis.infrastructure.handlers;

import com.equadis.events.AccountOpenedEvent;
import com.equadis.events.FundsDepositedEvent;
import com.equadis.events.FundsWithdrawnEvent;

public interface EventHandler {
    void on(AccountOpenedEvent event);
    void on(FundsDepositedEvent event);
    void on(FundsWithdrawnEvent event);
}
