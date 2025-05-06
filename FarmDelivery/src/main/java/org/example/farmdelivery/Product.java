package org.example.farmdelivery;

public class Product {
    private String name;
    private String imageUrl;
    private double price;
    private String description;

    public Product(String name, String imageUrl, double price) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getPrice() {
        return price;
    }
}
