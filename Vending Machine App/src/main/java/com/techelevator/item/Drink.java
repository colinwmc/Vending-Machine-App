package com.techelevator.item;

public class Drink extends Item{

    public Drink(String name, double price, String slotLocation) {
        super(name, price, slotLocation);
    }

    @Override
    public String printMessage() {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
