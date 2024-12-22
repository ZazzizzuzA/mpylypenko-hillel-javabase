package com.gmail.mpylypenko.homeworks.hw141;

import java.util.Scanner;

public class DemoPrinter {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ConsolePrinter printer = new ConsolePrinter();
        System.out.println("Максимальна кількість повторень програми 10!");
        for (int i = 0; i < 10; i++) {

            String wantSend = readString("Бажаєте відправити повідомлення?(так/ні)");
            if (!wantSend.startsWith("т") && wantSend.length() <= 3) {
                System.out.println("Кінець програми.");
                return;
            }

            String sender = readString("Хто відправник?");
            String text = readString("Що необхідно надрукувати?");

            ConsolePrinter.Message message = new ConsolePrinter.Message(sender, text);

            printer.print(message);

            if (i == 9) {
                System.out.println("Вибачте, максимальна кількість повторень 10. Кінець програми.");
                return;
            }
        }
    }

    private static String readString(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }

    private static int readInt(String text) {
        System.out.println(text);
        return scanner.nextInt();
    }
}
