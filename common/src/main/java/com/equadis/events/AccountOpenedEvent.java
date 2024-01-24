package com.equadis.events;


import lombok.Getter;

@Getter
public class AccountOpenedEvent extends BaseEvent {
    // Getter methods for additional fields
    private final String accountType;
    private final double initialBalance;

    public AccountOpenedEvent(String id, String accountType, double initialBalance) {
        this.accountType = accountType;
        this.initialBalance = initialBalance;
    }

    @Override
    public String toString() {
        return "AccountOpenedEvent{" +
                "accountType='" + accountType + '\'' +
                ", initialBalance=" + initialBalance +
                '}';
    }
}
