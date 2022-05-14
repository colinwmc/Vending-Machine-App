package com.techelevator.item;

public abstract class Item {
    private String name;
    private double price;
    private String slotLocation;
    private int quantityAvailable = 7;
    private int quantitySold = 0;


    public Item(String name, double price, String slotLocation){
        this.name = name;
        this.price = price;
        this.slotLocation = slotLocation;
        }


    public abstract String printMessage();

    public String productInfo(){
        String forInfo = name;
        while(forInfo.length() < 17){
           forInfo = forInfo + " ";
        }
      return slotLocation + ": " +  forInfo + " $" + price + " " + quantityAvailable + " available | ";
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold += quantitySold;
    }

    public int getQuantitySold() {
        return quantitySold;
    }
}
