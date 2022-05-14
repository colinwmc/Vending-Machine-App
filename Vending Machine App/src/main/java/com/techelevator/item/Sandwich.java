package com.techelevator.item;

public class Sandwich extends Item{
    public Sandwich(String name, double price, String slotLocation) {
        super(name, price, slotLocation);
    }

    @Override
    public String printMessage() {
        return "Sandwich So Delicious, Yum!";
    }
}
