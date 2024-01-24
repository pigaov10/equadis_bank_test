package com.equadis.api.commands;


import com.equadis.infrastructure.BaseCommand;
import lombok.Data;
import lombok.experimental.SuperBuilder;


@Data
public class WithdrawFundsCommand extends BaseCommand {
    private String id;
    private double amount;
}
