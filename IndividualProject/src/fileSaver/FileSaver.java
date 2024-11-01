
package fileSaver;

import application.GameLogic;
import domain.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileSaver {

    public FileSaver(String filename) {


    }

    public void writeToFile(String name, int funds, ArrayList<String> destinationsVisited) {
        String saveString = "";

        // Saving the time
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        // Saving the funds
        String formattedFunds = Integer.toString(funds);
        // Saving the destinations visited
        String formattedDestinations = "";

        if (destinationsVisited.size() == 0) {
            saveString = name + ";" + formattedTime + ";" + formattedFunds + ";" + "\n";

        } else if (destinationsVisited.size() > 0) {
            for (String city : (ArrayList<String>) destinationsVisited) {
                if (formattedDestinations.length() > 0) {
                    formattedDestinations += " " + city;
                } else {
                    formattedDestinations += city;
                }
            }
            saveString = name + ";" + formattedTime + ";" + formattedFunds + ";" + formattedDestinations + "\n";
        }

        try {
            FileWriter writer = new FileWriter("scoreboard.txt", true);
            writer.write(saveString);
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (Exception c) {
            System.out.println("An error has occurred.");
        }

    }

    public String readFromFile() {
        String outputString = "";
        try {
            File scoreboardFile = new File("scoreboard.txt");
            Scanner reader = new Scanner(scoreboardFile);
            while (reader.hasNextLine()) {
                String currentString = reader.nextLine();

                //Breaks down each line on the string into save components
                String[] parts = currentString.split(";");
                String name = "";
                String time = "";
                String funds = "";
                String destinations = "";
                boolean noDestinationsVisited = true;

                if (parts.length >= 4) {
                    noDestinationsVisited = false;
                    name = parts[0];
                    time = parts[1];
                    funds = parts[2];
                    destinations = parts[3];
                } else if (parts.length < 4) {
                    name = parts[0];
                    time = parts[1];
                    funds = parts[2];
                    destinations = "No destinations visited yet";
                }

                //Further breaks down the destinations section into individual destinations
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

                if (noDestinationsVisited) {
                    destinationCount = 0;
                }

                if (destinationCount == 0) {
                    outputString += name + ", " + "GBP " + funds + ", " + Integer.toString(destinationCount) + " cities. Save time: " + time + "\n";
                } else if (destinationCount > 0) {
                    outputString += name + ", " + "GBP " + funds + ", " + Integer.toString(destinationCount) + " cities: " + destinationPrintout + ". Save time: " + time + "\n";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. ");

        } catch (Exception c) {
            System.out.println("An error has occurred. ");
        }
        return outputString;
    }
}


