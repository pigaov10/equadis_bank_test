package com.equadis.events;

import lombok.*;

@Getter
public class FundsDepositedEvent extends BaseEvent {
    private final double amount;

    public FundsDepositedEvent(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FundsDepositedEvent{" +
                "amount=" + amount +
                '}';
    }
}
