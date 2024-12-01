package com.gmail.mpylypenko.homeworks.hw111;

import java.util.Scanner;

public class CreatePerson {
    public static void main(String[] args) {
        String answerAboutDefaultValues = askClientString("Use default values to create persons? (yes/no)");
        boolean useDefaultValues = answerAboutDefaultValues.indexOf("y") == 0 && answerAboutDefaultValues.length() <= 3;
        Person person1 = createPerson(useDefaultValues);
        Person person2 = createPerson(useDefaultValues);
        Person person3 = createPerson(useDefaultValues);
        System.out.println("\t-=INFORMATION ABOUT PERSONS=-");
        print(person1);
        print(person2);
        print(person3);
        System.out.println("\t-=CHANGING PROFESSION FOR PERSON " + person3.name() + "=-");
        person3.setProfession("Soldier");
        System.out.println("\t-=CHANGED INFORMATION ABOUT PERSON=-");
        print(person3);
    }

    private static Person createPerson(boolean useDefaultValues) {
        System.out.println("\t-=CREATE A NEW PERSON=-");
        if (useDefaultValues) {
            return new Person();
        }
        String name = askClientString("What is name of your character?");
        int age = askClientAge();
        String profession = askClientString("What kind of profession has your character?");
        return new Person(name, age, profession);
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

    private static void print(Person person) {
        System.out.print("Name: " + person.name());
        System.out.print("; Age: " + person.age());
        System.out.println("; Profession: " + person.profession());
    }
}
