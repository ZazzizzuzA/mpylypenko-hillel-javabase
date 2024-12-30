package com.gmail.mpylypenko.homeworks.hw111;

import java.util.Scanner;

public class CreatePerson {
    public static void main(String[] args) {
        String answerAboutDefaultValues = askClientString("Use default values to create persons? (yes/no)");
        boolean useDefaultValues = answerAboutDefaultValues.indexOf("y") == 0 && answerAboutDefaultValues.length() <= 3;

        Person[] persons = new Person[3];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = useDefaultValues ? createDefaultPerson() : createPerson();
        }

        System.out.println("\t-=INFORMATION ABOUT PERSONS=-");
        for (Person person: persons) {
            person.printInfo();
        }
        System.out.println("\t-=CHANGING PROFESSION FOR PERSON " + persons[2].name() + "=-");
        persons[2].setProfession("Soldier");
        System.out.println("\t-=CHANGED INFORMATION ABOUT PERSON=-");
        persons[2].printInfo();
    }

    private static Person createPerson() {
        System.out.println("\t-=CREATE A NEW PERSON=-");
        String name = askClientString("What is name of your character?");
        int age = askClientAge();
        String profession = askClientString("What kind of profession has your character?");
        return new Person(name, age, profession);
    }

    private static Person createDefaultPerson() {
        System.out.println("\t-=CREATE A NEW PERSON=-");
        return new Person();
    }

    private static String askClientString(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextLine();
    }

    private static int askClientAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How old is your character?");
        return scanner.nextInt();
    }
}
