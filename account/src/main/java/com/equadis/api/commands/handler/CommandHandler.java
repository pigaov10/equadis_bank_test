package com.equadis.api.commands.handler;


import com.equadis.api.commands.OpenAccountCommand;

public interface CommandHandler {
    void handle(OpenAccountCommand command);
}
