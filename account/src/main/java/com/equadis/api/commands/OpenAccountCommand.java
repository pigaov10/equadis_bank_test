package com.equadis.api.commands;

import com.equadis.infrastructure.BaseCommand;
import lombok.Data;

@Data
public class OpenAccountCommand extends BaseCommand {
    private String holder;
    private double initialBalance;
}
