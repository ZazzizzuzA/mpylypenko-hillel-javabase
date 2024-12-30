package com.gmail.mpylypenko.homeworks.hw111;

import java.util.Random;

public class Person {
    private String name;
    private int age;
    private String profession;

    Person(String name, int age, String profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    Person() {
        String[] names = {"Steve", "Joker", "Joshua", "Maximus", "Freddie", "Roger", "Scot"};
        int[] ages = {13, 65, 76, 45, 3, 34, 54, 72, 98, 12, 54};
        String[] professions = {"Stalker", "Wanderer", "Zookeeper", "Judge", "Farmer", "Writer", "Worker", "Driver"};
        Random random = new Random();
        int index = random.nextInt(names.length);
        setName(names[index]);
        index = random.nextInt(ages.length);
        setAge(ages[index]);
        index = random.nextInt(professions.length);
        setProfession(professions[index]);
    }

    public String name() {
        return this.name;
    }

    public String profession() {
        return this.profession;
    }

    public int age() {
        return this.age;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printInfo() {
        System.out.print("Name: " + this.name);
        System.out.print("; Age: " + this.age);
        System.out.println("; Profession: " + this.profession);
    }
}
