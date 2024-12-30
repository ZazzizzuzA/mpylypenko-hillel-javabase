package com.gmail.mpylypenko.homeworks.hw121;

public class Car {
    public Car() {

    }

    public void start() {
        System.out.println("-= CAR IS STARTING =-");
        this.startElectricity();
        this.startCommand();
        this.startFuelSystem();
    }

    private void startElectricity() {
        System.out.println("-= 1. START ELECTRICITY =-");
    }

    private void startCommand() {
        System.out.println("-= 2. START COMMAND =-");
    }

    private void startFuelSystem() {
        System.out.println("-= 3. START FUEL SYSTEM =-");
    }
}
