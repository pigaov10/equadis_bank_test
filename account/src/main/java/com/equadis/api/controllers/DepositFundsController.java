package com.equadis.api.controllers;


import com.equadis.api.commands.DepositFundsCommand;
import com.equadis.api.commands.WithdrawFundsCommand;
import com.equadis.api.controllers.dto.BaseResponse;
import com.equadis.infrastructure.CommandDispatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/api/v1/depositFunds")
public class DepositFundsController {
    private final Logger logger = Logger.getLogger(WithdrawFundsController.class.getName());

    private final CommandDispatcher commandDispatcher;

    public DepositFundsController(CommandDispatcher commandDispatcher) {
        this.commandDispatcher = commandDispatcher;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> depositFunds(@PathVariable(value = "id") String id,
                                               @RequestBody DepositFundsCommand command) {
        try {
            commandDispatcher.send(command);
            return new ResponseEntity<>(new BaseResponse("Deposit completed successfully!"), HttpStatus.OK);
        } catch (IllegalStateException e) {
            logger.warning(MessageFormat.format("Client made a bad request - {0}.", e.toString()));
            return new ResponseEntity<>(new BaseResponse(e.toString()), HttpStatus.BAD_REQUEST);
        }
    }
}
