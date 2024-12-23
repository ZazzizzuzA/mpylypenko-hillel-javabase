package com.gmail.mpylypenko.homeworks.hw151;

import java.util.Scanner;

public class DemoAdviser {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Adviser adviser = new Adviser();
        Day day = selectedDay();
        adviser.advise(day);
    }

    private static Day selectedDay() {
        int userChoice = selectionMenu();
        return switch (userChoice) {
            case 1 -> Day.MONDAY;
            case 2 -> Day.TUESDAY;
            case 3 -> Day.WEDNESDAY;
            case 4 -> Day.THURSDAY;
            case 5 -> Day.FRIDAY;
            case 6 -> Day.SATURDAY;
            case 7 -> Day.SUNDAY;
            default -> throw new IllegalStateException("Unexpected value: " + userChoice);
        };
    }

    private static int selectionMenu() {
        System.out.println("Select your day:");
        Day[] days = Day.values();
        for (int i = 1; i <= days.length; i++) {
            System.out.println(i + " - " + days[i - 1]);
        }
        System.out.println("You choosing:");
        return scanner.nextInt();
    }
}
