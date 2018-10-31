package com.example.recyclerviewtest;

public class Fruit {
    private String fruitName;
    private int fruitImage;

    public Fruit(String name, int image) {
        this.fruitName = name;
        this.fruitImage = image;
    }

    public String getFruitName() {
        return fruitName;
    }

    public int getFruitImage() {
        return fruitImage;
    }
}
