package com.marianowinar.logic.entity.impl;

import com.marianowinar.logic.enums.Quality;

public abstract class Garment {
    private Long garmentId;
    private String name;
    private Quality quality;
    private double price;
    private int stock;

    public Garment() {}

    public Garment(Long garmentId, String name, String description, Quality quality, double price, int stock) {
        this.garmentId = garmentId;
        this.name = name;
        this.quality = quality;
        this.price = price;
        this.stock = stock;
    }

    public Long getGarmentId() {
        return garmentId;
    }

    public void setGarmentId(Long garmentId) {
        this.garmentId = garmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
