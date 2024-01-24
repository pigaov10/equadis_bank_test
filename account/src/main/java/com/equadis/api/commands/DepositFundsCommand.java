package com.equadis.api.commands;

import com.equadis.infrastructure.BaseCommand;
import lombok.Data;


@Data
public class DepositFundsCommand extends BaseCommand {
    private double amount;
}
