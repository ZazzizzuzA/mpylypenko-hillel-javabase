package com.gmail.mpylypenko.homeworks.hw151;

public enum Day {
    MONDAY("MONDAY"),
    TUESDAY("TUESDAY"),
    WEDNESDAY("WEDNESDAY"),
    THURSDAY("THURSDAY"),
    FRIDAY("FRIDAY"),
    SATURDAY("SATURDAY"),
    SUNDAY("SUNDAY"),
    UNKNOWN("UNKNOWN DAY");

    private final String currentDay;

    Day(String day) {
        this.currentDay = day;
    }

    public String getCurrentDay() {
        return this.currentDay;
    }

    public static String[] getListDays() {
        return new String[]{
                MONDAY.getCurrentDay(),
                TUESDAY.getCurrentDay(),
                WEDNESDAY.getCurrentDay(),
                THURSDAY.getCurrentDay(),
                FRIDAY.getCurrentDay(),
                SATURDAY.getCurrentDay(),
                SUNDAY.getCurrentDay()
        };
    }
}
