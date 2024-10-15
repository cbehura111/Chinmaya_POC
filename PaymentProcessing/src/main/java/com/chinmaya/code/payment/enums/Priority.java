package com.chinmaya.code.payment.enums;

public enum Priority {
    LOW(0),
    MEDIUM(1),
    HIGH(2);

    private final int priorityVal;

    // Constructor
    Priority(int priorityVal) {
        this.priorityVal = priorityVal;
    }

    // Getter method
    public int getPriority() {
        return priorityVal;
    }

    public static Priority fromValue(int value) {
        for (Priority priority : Priority.values()) {
            if (priority.getPriority() == value) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Unknown priority value: " + value);
    }
}
