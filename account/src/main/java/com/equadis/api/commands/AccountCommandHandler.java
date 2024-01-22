package com.equadis.api.commands;

import org.springframework.stereotype.Service;

@Service
public class AccountCommandHandler implements CommandHandler {
    @Override
    public void handle(OpenAccountCommand command) {
        var a = 1;
    }
}
