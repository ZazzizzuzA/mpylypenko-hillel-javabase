package com.gmail.mpylypenko.homeworks.hw121;

import java.util.Scanner;

public class DemoClass {
    public static void main(String[] args) {
        runWorkerDemo();
        runDemoCar();
    }

    private static void runDemoCar() {
        System.out.println("-=RUN DEMO OF CAR CLASS=-");
        Car car = new Car();
        car.start();
    }

    private static void runWorkerDemo() {
        System.out.println("-=RUN DEMO OF WORKER CLASS=-");
        String name = askClientString("What is the name of your worker?");
        String position = askClientString("What position does your worker hold??");
        String email = askClientString("What is the email of your worker?");
        String phone = askClientString("What is the phone of your worker?");
        int age = askClientAge();
        System.out.println("-=CREATING A WORKER=-");
        Worker worker = new Worker(name, position, email, phone, age);
        System.out.println("-=WORKER " + worker.getName() + " IS READY=-");
        worker.printInfo();
        System.out.println("-=WORKER " + worker.getName() + " GETTING OLDER AND CHANGING HIS JOB=-");
        worker.setAge(worker.getAge() + 1);
        worker.setPosition("musician");
        worker.printInfo();
    }

    private static String askClientString(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextLine();
    }

    private static int askClientAge() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How old is your worker?");
        return scanner.nextInt();
    }
}
