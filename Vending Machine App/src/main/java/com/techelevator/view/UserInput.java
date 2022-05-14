package com.techelevator.view;

import com.techelevator.Utilities.Colors;


import java.util.Scanner;
public class UserInput {

    private static Scanner userInput = new Scanner(System.in);


    public static String showMainMenu() {
        System.out.println(Colors.Cyan+"*********************************");
        System.out.println(Colors.Purple+"    Welcome, Valued Customer!    ");
        System.out.println(Colors.Cyan+"*********************************"+Colors.Reset);
        System.out.println("(D) Display caTEring Items");
        System.out.println("(P) Purchase");
        System.out.println("(E) Exit");
        System.out.print("Please make a selection:");
        String mainMenuReply = userInput.nextLine().toUpperCase();

        switch (mainMenuReply) {
            case "D":
                return "Display";
            case "P":
                return "Purchase";
            case "E":
                return "Exit";
            case "S":
                return "Sales Report";
            case "R":
                return "Full Report";
            default:
                return "Invalid";    // added this to the display option
        }
    }

    public static String bottomOfDisplay() {
        System.out.println("\n\n" + "(P) Make a Purchase");
        System.out.println("(B) Go Back to Main Menu");
        System.out.print("Please Select an Option:");
        String bottomOfDisplayChoice = userInput.nextLine().toUpperCase();

        switch (bottomOfDisplayChoice) {
            case "P":
                return "Purchase";
            case "B":
                return "Back";
            default:
                return "Invalid";
        }
    }
                                                    //We could pass in totalMoneyProvided into this Method!
    public static String displayPurchaseMenu(double totalMoneyProvided) {
        System.out.println("");
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");
        System.out.println("Current Money Provided: $"+ String.format("%.2f", totalMoneyProvided));
        System.out.print("\n"+"Please select an option:");
        String purchaseMenuReply = userInput.nextLine().toUpperCase();

        switch (purchaseMenuReply) {
            case "M":
                return "Feed Money";
            case "S":
                return "Select Item";
            case "F":
                return "Finish Transaction";
//            case "B":
//                return "Back";
            default:
                return "Invalid Response";

        }
    }

    public static double feedMoney() {

        System.out.println("Machine accepts bills in the following denominations:");
        System.out.println("$1");
        System.out.println("$5");
        System.out.println("$10");
        System.out.println("$20");
        System.out.print("Please Insert Your Money:");
        String feedMoneyInput = userInput.nextLine().replace("$", "");
        switch (feedMoneyInput) {
            case "1":
                return 1.00;
            case "5":
                return 5.00;
            case "10":
                return 10.00;
            case "20":
                return 20.00;
            default:
                return 0.00;

        }
    }
    public static String selectItem(){
        System.out.print("\n" +"\n"+ "Please input item code: ");
        String itemSelection = userInput.nextLine().toUpperCase();
        return itemSelection;
    }


}
