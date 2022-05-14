package com.techelevator.view;

import com.techelevator.Utilities.Colors;

import java.io.IOException;


public class PurchaseMenu extends MainMenu {



    public void run() {

        String choice = UserInput.displayPurchaseMenu(totalMoneyProvided);

        while (!choice.equals("Finish Transaction")) {

            if (choice.equals("Feed Money")) {
                double inserted = UserInput.feedMoney();
                super.totalMoneyProvided += inserted;
                //System.out.println(super.totalMoneyProvided);
                if (inserted == 0.00) {
                    System.out.println("\u001B[31m" + "Sorry, your payment was not accepted." + "\u001B[0m");
                }
                String moneyFeed = String.format("%-22s", "MONEY FED:");
                super.auditLogger.write(moneyFeed + " $" + String.format("%.2f", inserted) + " $" + String.format("%.2f",totalMoneyProvided));
                choice = UserInput.displayPurchaseMenu(totalMoneyProvided);

            }

            if (choice.equals("Select Item")) {
                UserOutput.displayItems(super.currentInventory);
                String itemSelection = UserInput.selectItem();
                if (currentInventory.containsKey(itemSelection)) {
                    if (currentInventory.get(itemSelection).getQuantityAvailable() > 0) {
                        if (currentInventory.get(itemSelection).getPrice() <= totalMoneyProvided) {
                            dispenseItem(itemSelection);
                        } else {
                            System.out.println(Colors.Red + "Please enter more money for the item selected." + Colors.Reset);
                        }
                    } else {
                        System.out.println(Colors.Red + "Sorry that Item is no longer available." + Colors.Reset);
                    }

                } else {
                    System.out.println(Colors.Red + "Please select valid Item" + Colors.Reset);
                }
                choice = UserInput.displayPurchaseMenu(totalMoneyProvided);
            }
            if(choice.equals("Invalid Response")){
                System.out.println(Colors.Red + "I'm sorry, I didn't understand that. Please enter a response from the list above."+ "\n" + Colors.Reset);
                choice = UserInput.displayPurchaseMenu(totalMoneyProvided);
            }
        }
if(totalMoneyProvided>0.1){
    System.out.println(giveChange(totalMoneyProvided));
    UserOutput.goodByeMessage();
    System.out.println("\n");
    totalMoneyProvided = 0;
}
else{
           UserOutput.goodByeMessage();
        }
//super.run();
    }

    public void dispenseItem(String itemSelection) {
        int currentAvailable = currentInventory.get(itemSelection).getQuantityAvailable() - 1;
        currentInventory.get(itemSelection).setQuantityAvailable(currentAvailable);

        currentInventory.get(itemSelection).setQuantitySold(1);

        totalMoneyProvided -= currentInventory.get(itemSelection).getPrice();


        System.out.println("\n"+currentInventory.get(itemSelection).getName() + " $" +  currentInventory.get(itemSelection).getPrice() +
                " - Money Remaining: $" + String.format("%.2f", totalMoneyProvided) + "\n" + currentInventory.get(itemSelection).printMessage() + "\n");

        double temp = totalMoneyProvided + currentInventory.get(itemSelection).getPrice();
        String beforeDispensed = String.format("%.2f", temp);
        String itemName = String.format("%-20s", currentInventory.get(itemSelection).getName());

        super.auditLogger.write(itemName + currentInventory.get(itemSelection).getSlotLocation() + " $" + beforeDispensed + " $" + String.format("%.2f", totalMoneyProvided));

//        try {
//            super.auditLogger.close();
//        } catch (IOException e) {
//            System.out.println("Error in closing the file");
//        }
    }

    public String giveChange(Double totalMoney){
        int numberOfDollars=totalMoney.intValue();
        int cents=(int)Math.ceil((totalMoney-numberOfDollars)*100);
        int numberOfQuarters=0;
        int numberOfDimes=0;
        int numberOfNickels=0;
        if(cents>=25){
            numberOfQuarters=cents/25;
            cents=cents%25;
        }
        if(cents>=10){
            numberOfDimes=cents/10;
            cents=cents%10;
        }
        if(cents>=5){
            numberOfNickels=cents/5;
            cents=cents%5;
//            if(cents>0){
//                System.out.println("rounding error");
        }

        String endingMessage="Your change of $"+ String.format("%.2f", totalMoney) +" will be returned as:";
        if(numberOfDollars>0) {
            endingMessage += "\n" + numberOfDollars + " One dollar bill(s)";
        }
        if(numberOfQuarters>0) {
            endingMessage += "\n" + numberOfQuarters + " quarter(s)";
        }
        if(numberOfDimes>0) {
            endingMessage += "\n" + numberOfDimes + " dime(s)";
        }
        if(numberOfNickels>0) {
            endingMessage += "\n" + numberOfNickels + " nickel(s)";
        }
//        endingMessage+="\n"+"Thank You! Please come again.";

        String changeGiven = "CHANGE GIVEN:";
        String formatAuditChange = String.format("%-22s", changeGiven);

        super.auditLogger.write(formatAuditChange + " $" + String.format("%.2f", totalMoneyProvided) + " $0.00");


        return endingMessage;
    }

}
