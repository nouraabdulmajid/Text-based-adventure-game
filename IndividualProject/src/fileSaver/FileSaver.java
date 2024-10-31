/*
package fileSaver;

import domain.City;

import java.util.Scanner;
import java.io.FileWriter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileSaver {
    private FileWriter writer;
    private Scanner reader;

    public FileSaver(String filename) {
        this.writer = new FileWriter(filename, true);
        this.reader = new Scanner(System.in);

    }

    public void writeToFile(String name, int funds, ArrayList destinationsVisited) {
        // Saving the time
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        // Saving the funds
        String formattedFunds = Integer.toString(funds);
        // Saving the destinations visited
        String formattedDestinations = "";
        for (City c: destinationsVisited) {
            if (formattedDestinations.length() > 0) {
                formattedDestinations += " " + c.getName();
            } else {
                formattedDestinations += c.getName();
            }

        }
        String saveString = name + ";" + formattedTime + ";" + formattedFunds + ";" + formattedDestinations;
        this.writer.write(saveString);
        this.writer.close();


    }

    public String readFromFile() {
        String outputString = "";
        while (reader.hasNextLine()) {
            String currentString = reader.nextLine();
            String[] parts = currentString.split(";");
            String name = parts[0];
            String time = parts[1];
            String funds = parts[2];
            String destinations = parts[3];
            String[] destinationsList = destinations.split(" ");
            int destinationCount = 0;
            String destinationPrintout = "";
            for (String d : destinationsList) {
                destinationCount += 1;
                if (destinationCount <= 1) {
                    destinationPrintout += d;
                } else if (destinationCount > 1) {
                    destinationPrintout += ", " + d;
                }
            }

            if (destinationCount == 0) {
                outputString += name + ", " + "£" + funds + ", " + Integer.toString(destinationCount) + " cities. Save time: " + time + "\n";
            } else if (destinationCount > 0) {
                outputString += name + ", " + "£" + funds + ", " + Integer.toString(destinationCount) + " cities: " + destinationPrintout + ". Save time: " + time + "\n";
            }
            return outputString;
        }




    }
}

*/
