package com.gmail.mpylypenko.homeworks.hw151;

public class Adviser implements AdviserInterface {

    @Override
    public void advise(Day day) {
        switch (day) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY:
                System.out.println("Be productive today. \nIt's better, than be not productive.\nBut... \nIt's just people saying and WE ARE LIVE IN " +
                        "SOCIETY. So... \nBe " +
                        "happy today. It's really better. My opinion :)");
                break;
            case FRIDAY:
                System.out.println("Happy friday!)");
                break;
            case SATURDAY:
                System.out.println("It's saturday! Time to go find a job.");
                break;
            case SUNDAY:
                System.out.println("It's sunday! Time to go faster and find a JOB!");
                break;
            default:
                System.out.println("Unknown day");
                break;
        }
    }
}
