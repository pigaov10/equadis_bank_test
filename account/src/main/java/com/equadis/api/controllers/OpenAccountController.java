package com.equadis.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/openBankAccount")
public class OpenAccountController {
    @PostMapping
    public ResponseEntity<Object> openAccount(@RequestBody Object command) {
        return ResponseEntity.ok().body("Returning an object");
    }
}
