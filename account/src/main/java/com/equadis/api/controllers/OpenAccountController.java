package com.equadis.api.controllers;

import com.equadis.api.commands.OpenAccountCommand;
import com.equadis.infrastructure.BaseCommand;
import com.equadis.infrastructure.CommandDispatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/openBankAccount")
public class OpenAccountController {

    private final CommandDispatcher commandDispatcher;

    public OpenAccountController(CommandDispatcher commandDispatcher) {
        this.commandDispatcher = commandDispatcher;
    }

    @PostMapping
    public ResponseEntity<Object> openAccount(@RequestBody OpenAccountCommand command) {
        commandDispatcher.send(command);
        return ResponseEntity.ok().body("Returning an object");
    }
}
