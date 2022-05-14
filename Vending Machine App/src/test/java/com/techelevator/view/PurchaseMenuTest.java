package com.techelevator.view;

import com.sun.tools.javac.Main;
import com.techelevator.item.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class PurchaseMenuTest {
    PurchaseMenu purchaseMenu = new PurchaseMenu();
    MainMenu mainMenu = new MainMenu();
    Map<String, Item> test = mainMenu.currentInventory;






    @Test
    public void change_when_total_money_equals_whole_numnber(){
        double totalMoney = 10.00;
        int numberOfDollars = 10;
        String expected = "Your change of $"+ String.format("%.2f", totalMoney) +" will be returned as:" + "\n" + numberOfDollars + " One dollar bill(s)";
        Assert.assertEquals(expected, purchaseMenu.giveChange(totalMoney));

        double totalMoney2 = 73.00;
        int numberOfDollars2 = 73;
        String expected2 = "Your change of $"+ String.format("%.2f", totalMoney2) +" will be returned as:" + "\n" + numberOfDollars2 + " One dollar bill(s)";
        Assert.assertEquals(expected2, purchaseMenu.giveChange(totalMoney2));
    }

    @Test
    public void change_with_dollars_and_quarters(){
        double totalMoney = 7.50;
        int numberOfDollars = 7;
        int numberOfQuarters = 2;
        String expected = "Your change of $"+ String.format("%.2f", totalMoney) +" will be returned as:" + "\n" + numberOfDollars + " One dollar bill(s)" + "\n" + numberOfQuarters + " quarter(s)";
        Assert.assertEquals(expected, purchaseMenu.giveChange(totalMoney));

        double totalMoney2 = 1.75;
        int numberOfDollars2 = 1;
        int numberOfQuarters2 = 3;
        String expected2 = "Your change of $"+ String.format("%.2f", totalMoney2) +" will be returned as:" + "\n" + numberOfDollars2 + " One dollar bill(s)" +"\n" + numberOfQuarters2 + " quarter(s)";
        Assert.assertEquals(expected2, purchaseMenu.giveChange(totalMoney2));

        double totalMoney3 = 117.25;
        int numberOfDollars3 = 117;
        int numberOfQuarters3 = 1;
        String expected3 = "Your change of $"+ String.format("%.2f", totalMoney3) +" will be returned as:" + "\n" + numberOfDollars3 + " One dollar bill(s)" + "\n" + numberOfQuarters3 + " quarter(s)";
        Assert.assertEquals(expected3, purchaseMenu.giveChange(totalMoney3));
    }

    @Test
    public void change_with_dollars_quarters_dimes(){
        double totalMoney = 8.95;
        int numberOfDollars = 8;
        int numberOfQuarters = 3;
        int numberOfDimes = 2;
        String expected = "Your change of $"+ String.format("%.2f", totalMoney) +" will be returned as:" + "\n" + numberOfDollars + " One dollar bill(s)" + "\n" + numberOfQuarters + " quarter(s)"
                +"\n" + numberOfDimes + " dime(s)";
        Assert.assertEquals(expected, purchaseMenu.giveChange(totalMoney));

        double totalMoney2 = 12.35;
        int numberOfDollars2 = 12;
        int numberOfQuarters2 = 1;
        int numberOfDimes2 = 1;
        String expected2 = "Your change of $"+ String.format("%.2f", totalMoney2) +" will be returned as:" + "\n" + numberOfDollars2 + " One dollar bill(s)" +"\n" + numberOfQuarters2 + " quarter(s)"
                +"\n" + numberOfDimes2 + " dime(s)";

        double totalMoney3 = 135.45;
        int numberOfDollars3 = 135;
        int numberOfQuarters3 = 1;
        int numberOfDimes3 = 2;
        String expected3 = "Your change of $"+ String.format("%.2f", totalMoney3) +" will be returned as:" + "\n" + numberOfDollars3 + " One dollar bill(s)" + "\n" + numberOfQuarters3 + " quarter(s)"
                +"\n" + numberOfDimes3 + " dime(s)";
        Assert.assertEquals(expected3, purchaseMenu.giveChange(totalMoney3));
    }

    @Test
    public void change_with_dollars_quarters_dimes_nickels(){
        double totalMoney = 9.90;
        int numberOfDollars = 9;
        int numberOfQuarters = 3;
        int numberOfDimes = 1;
        int numberOfNickels = 1;
        String expected = "Your change of $"+ String.format("%.2f", totalMoney) +" will be returned as:" + "\n" + numberOfDollars + " One dollar bill(s)" + "\n" + numberOfQuarters + " quarter(s)"
                +"\n" + numberOfDimes + " dime(s)"+"\n" + numberOfNickels + " nickel(s)";
        double totalMoney2 = 32.40;
        int numberOfDollars2 = 32;
        int numberOfQuarters2 = 1;
        int numberOfDimes2 = 1;
        int numberOfNickels2 = 1;
        String expected2 = "Your change of $"+ String.format("%.2f", totalMoney2) +" will be returned as:" + "\n" + numberOfDollars2 + " One dollar bill(s)" + "\n" + numberOfQuarters2 + " quarter(s)"
                +"\n" + numberOfDimes2 + " dime(s)"+"\n" + numberOfNickels2 + " nickel(s)";

        double totalMoney3 = 139.65;
        int numberOfDollars3 = 139;
        int numberOfQuarters3 = 2;
        int numberOfDimes3 = 1;
        int numberOfNickels3 = 1;
        String expected3 = "Your change of $"+ String.format("%.2f", totalMoney3) +" will be returned as:" + "\n" + numberOfDollars3 + " One dollar bill(s)" + "\n" + numberOfQuarters3 + " quarter(s)"
                +"\n" + numberOfDimes3 + " dime(s)"+ "\n" + numberOfNickels3 + " nickel(s)";

        Assert.assertEquals(expected3, purchaseMenu.giveChange(totalMoney3));

    }

    @Test
    public void change_only_coins(){
        String expected = "Your change of $0.90 will be returned as:\n3 quarter(s)\n1 dime(s)\n1 nickel(s)";
        Assert.assertEquals(expected, purchaseMenu.giveChange(.90));

        String expected2 = "Your change of $0.15 will be returned as:" + "\n1 dime(s)\n1 nickel(s)";
        Assert.assertEquals(expected2, purchaseMenu.giveChange(.15));

        String expected3 = "Your change of $0.95 will be returned as:\n3 quarter(s)\n2 dime(s)";
        Assert.assertEquals(expected3, purchaseMenu.giveChange(.95));
    }

    @Test
    public void item_is_reduced_from_quantity_available(){
        purchaseMenu.dispenseItem("B2");
        Assert.assertEquals(6, test.get("B2").getQuantityAvailable());

        purchaseMenu.dispenseItem("B2");
        Assert.assertEquals(5, test.get("B2").getQuantityAvailable());

        purchaseMenu.dispenseItem("A2");
        Assert.assertEquals(6, test.get("A2").getQuantityAvailable());

        //Console prints a negative number for these tests, but we have a filter to only allow it
        //to get to dispense item if there is enough money.
    }

    @Test
    public void correct_item_is_dispensed(){
        purchaseMenu.dispenseItem("C4");
        Assert.assertEquals("Chewy Bar", test.get("C4").getName());

        purchaseMenu.dispenseItem("B3");
        Assert.assertEquals("Papsi", test.get("B3").getName());

        purchaseMenu.dispenseItem("d2");
        Assert.assertEquals("Burrito", test.get("B2").getName());
    }

    @Test
    public void price_is_being_reduced(){
        purchaseMenu.totalMoneyProvided = 20.00;
        double expected = 20.00 - 2.45;
        purchaseMenu.dispenseItem("B3");

        Assert.assertEquals(17.55, purchaseMenu.totalMoneyProvided, .0001);
        purchaseMenu.dispenseItem("D1");
        Assert.assertEquals(15.20, purchaseMenu.totalMoneyProvided, .0001);
        purchaseMenu.dispenseItem("A2");
        Assert.assertEquals(9.95, purchaseMenu.totalMoneyProvided, .0001);
    }
}
