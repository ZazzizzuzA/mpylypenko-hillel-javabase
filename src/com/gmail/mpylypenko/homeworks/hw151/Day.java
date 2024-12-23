package com.gmail.mpylypenko.homeworks.hw151;

public enum Day {
    MONDAY("MONDAY"),
    TUESDAY("TUESDAY"),
    WEDNESDAY("WEDNESDAY"),
    THURSDAY("THURSDAY"),
    FRIDAY("FRIDAY"),
    SATURDAY("SATURDAY"),
    SUNDAY("SUNDAY");

    private final String currentDay;

    Day(String day) {
        this.currentDay = day;
    }

    public String getCurrentDay() {
        return this.currentDay;
    }
}
