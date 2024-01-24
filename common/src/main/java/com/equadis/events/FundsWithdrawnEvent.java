package com.equadis.events;


import lombok.Getter;

@Getter
public class FundsWithdrawnEvent extends BaseEvent {
    private final double amount;

    public FundsWithdrawnEvent(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "FundsWithdrawnEvent{" +
                "amount=" + amount +
                '}';
    }
}
