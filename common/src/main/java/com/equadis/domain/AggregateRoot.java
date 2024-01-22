package com.equadis.domain;

import com.equadis.events.BaseEvent;
import lombok.Data;
import lombok.Getter;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AggregateRoot {
    private final Logger logger = Logger.getLogger(AggregateRoot.class.getName());

    @Getter
    protected String id;

    protected void applyChange(BaseEvent event, Boolean isNewEvent) {
        try {
            Method method = getClass().getDeclaredMethod("apply", event.getClass());
            method.setAccessible(true);
            method.invoke(this, event);
        } catch (NoSuchMethodException e) {
            logger.log(Level.WARNING, MessageFormat.format("The apply method was not found in the aggregate for {0}", event.getClass().getName()));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error applying event to aggregate", e);
        }
    }

    public void raiseEvent(BaseEvent event) {
        applyChange(event, true);
    }
}
