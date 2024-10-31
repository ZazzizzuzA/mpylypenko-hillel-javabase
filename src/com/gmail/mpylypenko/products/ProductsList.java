package com.gmail.mpylypenko.products;

public class ProductsList {
    private static final String CURRENCY = "EUR";
    private static int numberOrder = 1;
    public static void main(String[] args) {
        String client = "Alice";
        String product = "smartphone";
        String address = "Moon Street, 10";
        float price = 309.99F;
        printOrder(client, product, address, price);
        client = "Tom";
        product = "laptop";
        address = "Terra Street, 17";
        price = 570.95F;
        printOrder(client, product, address, price);
        client = "Mr. Brown";
        product = "eco flow";
        address = "Leak Down avenue, 51";
        price = 500.79F;
        printOrder(client, product, address, price);
    }

    public static void printOrder(String client, String product, String address, float price) {
        System.out.println("Order No " + numberOrder++ + " Client: " + client);
        System.out.println("Product: " + product);
        System.out.println("Price: " + CURRENCY + " " + price);
        System.out.println("Address: " + address);
    }
}
