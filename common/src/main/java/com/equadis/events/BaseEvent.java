package com.equadis.events;


public class BaseEvent {
    private String id;
    private int version;

    // Default constructor
    public BaseEvent() {
    }

    // Parameterized constructor
    public BaseEvent(String id, int version) {
        this.id = id;
        this.version = version;
    }

    // Getter and setter methods for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and setter methods for version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "BaseEvent{" +
                "id='" + id + '\'' +
                ", version=" + version +
                '}';
    }
}
