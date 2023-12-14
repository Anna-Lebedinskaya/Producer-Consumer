package ru.cft.focus;

public class Product {
    private static int counter;
    private final int id;

    public Product() {
        synchronized (Product.class) {
            counter++;
            id = counter;
        }
    }

    public int getId() {
        return id;
    }
}
