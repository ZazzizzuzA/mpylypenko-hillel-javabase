package com.gmail.mpylypenko.homeworks.hw141;

import java.util.Scanner;

public class DemoPrinter {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PrinterRunner printer = new PrinterRunner();

        System.out.println("-=VALID MESSAGE=-");
        String sender = readString("Хто відправник?");
        String text = readString("Що необхідно надрукувати?");
        PrinterRunner.Message validMessage = new PrinterRunner.Message(sender, text);
        printer.print(validMessage);

        System.out.println("-=MESSAGE WITHOUT SENDER=-");
        text = readString("Аноніме, що необхідно надрукувати?");
        PrinterRunner.Message noSenderMessage = new PrinterRunner.Message(text);
        printer.print(noSenderMessage);

        System.out.println("-=MESSAGE WITHOUT SENDER AND TEXT=-");
        PrinterRunner.Message invalidMessage = new PrinterRunner.Message();
        printer.print(invalidMessage);

    }

    private static String readString(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }
}
