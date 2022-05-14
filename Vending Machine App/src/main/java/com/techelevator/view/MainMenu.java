package com.techelevator.view;

import com.techelevator.Utilities.Colors;
import com.techelevator.Utilities.Logger;
import com.techelevator.Utilities.SalesReporter;
import com.techelevator.Utilities.Stocker;
import com.techelevator.item.Item;

import java.io.File;
import java.io.IOException;
import java.util.Map;


public class MainMenu {


    Logger auditLogger = new Logger("audit.txt");
    double totalMoneyProvided = 0.00;


    Map<String, Item> currentInventory = Stocker.stockItems();


    public void run() {

        DisplayMenu displayMenu = new DisplayMenu();
        PurchaseMenu purchaseMenu = new PurchaseMenu();
        boolean keepRunning = true;

        while (keepRunning) {
            String choice = UserInput.showMainMenu();         //Did this to make sure correct responses are passed in.

            if (choice.equals("Invalid")) {
                System.out.println(Colors.Red + "I'm sorry I didn't understand that. Please enter a valid response from list above" + Colors.Reset);
            } else if (choice.equals("Display")) {
                displayMenu.run();
                break;
            } else if (choice.equals("Purchase")) {
                purchaseMenu.run();
            } else if (choice.equals("Sales Report")) {
                SalesReporter salesReporter = new SalesReporter();
                salesReporter.logSales(currentInventory);

            } else if (choice.equals("Full Report")) {
                SalesReporter fullReport = new SalesReporter();
                fullReport.fullSalesReport(currentInventory);

            } else if (choice.equals("Exit")) {
                UserOutput.goodByeMessage();
                keepRunning = false;
                try {
                    auditLogger.close();
                } catch (IOException e) {
                    System.out.println("Error closing ");
                    ;
                }
            }
        }


    }

    public Logger getAuditLogger() {
        return auditLogger;
    }

    public double getTotalMoneyProvided() {
        return totalMoneyProvided;
    }

    public Map<String, Item> getCurrentInventory() {
        return currentInventory;
    }
}


//        Stocker stocker;
//    {
//        try {
//            stocker = new Stocker();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    Map<String , Item> currentInventory = Stocker.stockItems();
//boolean keepRunning
//            PurchaseMenu purchaseMenu =new PurchaseMenu();
//            DisplayMenu displayMenu = new DisplayMenu();
