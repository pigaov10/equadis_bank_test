package com.equadis.infrastructure;

public interface CommandDispatcher {
    //<T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler);
    void send(Object command);
}