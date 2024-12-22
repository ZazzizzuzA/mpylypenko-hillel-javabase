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
        int counter = 7;
        do {
            int userChoice = selectionMenu(Day.getListDays());
            counter--;
            return switch (userChoice) {
                case 1 -> Day.MONDAY;
                case 2 -> Day.TUESDAY;
                case 3 -> Day.WEDNESDAY;
                case 4 -> Day.THURSDAY;
                case 5 -> Day.FRIDAY;
                case 6 -> Day.SATURDAY;
                case 7 -> Day.SUNDAY;
                default -> Day.UNKNOWN;
            };

        } while(counter > 0);
    }

    private static int selectionMenu(String[] days) {
        int selection;
        System.out.println("Select your day:");
        for (int i = 1; i <= days.length; i++) {
            System.out.println(i + " - " + days[i - 1]);
        }
        System.out.println("You choosing:");
        selection = scanner.nextInt();
        return selection;
    }
}
