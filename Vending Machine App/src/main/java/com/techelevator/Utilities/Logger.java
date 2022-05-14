package com.techelevator.Utilities;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private File logFile;
    private PrintWriter writer;
    LocalDateTime now = LocalDateTime.now();                                                //Should we put date time in the logger class?!
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");     //The only time we are using it is when printing to the reports.
    String formatDateTime = now.format(formatter);


    public Logger(String pathName) {
        this.logFile = new File(pathName);

        if (!logFile.exists()) {
            try {
                this.writer = new PrintWriter(this.logFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.writer = new PrintWriter(new FileWriter(this.logFile, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void write(String logMessage) {
        this.writer.println(formatDateTime + " " + logMessage);
        this.writer.flush();

    }
    public void writeSales(String logMessage) {
        this.writer.println(logMessage);
        this.writer.flush();

    }
    public void close() throws IOException {
        this.writer.close();
    }

}


