package com.techelevator.item;

public class Munchy extends Item{

    public Munchy(String name, double price, String slotLocation) {
        super(name, price, slotLocation);
    }

    @Override
    public String printMessage() {
        return "Munchy, Munchy, so Good!";
    }
}
