package com.equadis.api.commands.handler;


import com.equadis.api.commands.DepositFundsCommand;
import com.equadis.api.commands.OpenAccountCommand;
import com.equadis.api.commands.WithdrawFundsCommand;

public interface CommandHandler {
    void handle(OpenAccountCommand command);
    void handle(DepositFundsCommand command);
    void handle(WithdrawFundsCommand command);
}
