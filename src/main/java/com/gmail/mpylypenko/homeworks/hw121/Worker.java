package com.gmail.mpylypenko.homeworks.hw121;

public class Worker {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int age;

    public Worker(String name, String position, String email, String phone, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Hi! My name is " + this.getName() + ".\n" +
                "I am " + this.getAge() + " years old.\n" +
                "At work I am holding position " + this.getPosition() + ".\n" +
                "You can contact me using my email " + this.getEmail() + " or phone number " + this.getPhone() + ".\n";
    }
}
