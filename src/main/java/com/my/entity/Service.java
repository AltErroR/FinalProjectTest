package com.my.entity;

public class Service {
    private String name;
    private int price;

    public Service( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service { Name : " + name +
                " Price : " + price + " }";
    }
}
