package com.techelevator.item;

public class Dessert extends Item{
    public Dessert(String name, double price, String slotLocation) {
        super(name, price, slotLocation);
    }

    @Override
    public String printMessage() {
        return "Sugar, Sugar, so Sweet!";
    }
}
