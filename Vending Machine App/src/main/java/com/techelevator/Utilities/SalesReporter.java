package com.techelevator.Utilities;

import com.techelevator.item.Item;
import com.techelevator.view.MainMenu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

public class SalesReporter {

    private double totalSales = 0.00;
    private LocalDateTime now = LocalDateTime.now();                                                //Should we put date time in the logger class?!
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss");     //The only time we are using it is when printing to the reports.
    private String formatDateTime = now.format(formatter);

    public void logSales(Map<String, Item> currentInventory) {

        String salesFilePathName;
        salesFilePathName = "Sales Reports/Sales Report_"+formatDateTime+".csv";
        Logger salesReport = new Logger(salesFilePathName);


        for (String key : currentInventory.keySet()) {

            int quantitySold = 7 - currentInventory.get(key).getQuantityAvailable();
            salesReport.writeSales(currentInventory.get(key).getName() + "," + quantitySold);
            totalSales += (quantitySold*currentInventory.get(key).getPrice());
        }
        salesReport.writeSales("Total Gross Sales: $"+String.format("%.2f",totalSales));
        try {
            salesReport.close();
        } catch (IOException e) {
            System.out.println("Error in closing the file");
        }
    }

    public void fullSalesReport(Map<String, Item> currentInventory){

        String reportFilePathName;
        reportFilePathName = "Sales Reports/Full Report_" + formatDateTime +".csv";
        Logger fullReport = new Logger(reportFilePathName);
        File auditFile = new File("audit.txt");
        Scanner auditScanner = null;
        try {
            auditScanner = new Scanner(auditFile);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        double totalSales = 0.00;
        for (String slot : currentInventory.keySet()) {
            int numberSold = 0;
            try {
                auditScanner = new Scanner(auditFile);
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }

            while(auditScanner.hasNextLine()) {
                String line = auditScanner.nextLine();
                if(line.contains(slot)){
                    numberSold++;

                }
            }
            double salesTotal = numberSold * currentInventory.get(slot).getPrice();
            totalSales += salesTotal;
            String printReportPrice = String.format("%.2f", salesTotal);
            String format = String.format("%-20s", currentInventory.get(slot).getName() + ":");

            fullReport.writeSales(format + "Total quantity sold: " + numberSold
                    + "  Total sales: $" + printReportPrice);

        }
        String totalSalesFormat = String.format("%.2f", totalSales);
        fullReport.writeSales("Total gross sales: $" + totalSalesFormat);

//        for (String key : currentInventory.keySet()) {
//
//            String printReportPrice = String.format("%.2f", salesTotal);
//            String format = String.format("%-20s", currentInventory.get(key).getName() + ":");
//
//            fullReport.writeSales(format + "Total quantity sold:" + currentInventory.get(key).getQuantitySold()
//                    + "  Total sales: $" + printReportPrice);
//
//        }
        try {
            fullReport.close();
        } catch (IOException e) {
            System.out.println("Error in closing the file");
        }


    }
}
