package com.gmail.mpylypenko.lectures.lecture05;

public class RelationalDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = -123;

        boolean result = a > b;
        System.out.println("a > b is " + result);
        result = a < b;
        System.out.println("a < b is " + result);
        result = a >= b;
        System.out.println("a >= b is " + result);
        a = -123;
        result = a == b;
        System.out.println("a == b is " + result);
        result = a != b;
        System.out.println("a != b is " + result);
    }
}
