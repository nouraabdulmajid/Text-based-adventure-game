package presentation;

import fileSaver.*;
import application.*;
import domain.*;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Scanner reader;
    private GameLogic gameLogic;
    private FileSaver fileSaver;

    public UserInterface(Scanner scanner) {
        this.reader = scanner;
        this.gameLogic = new GameLogic();
        this.fileSaver = new FileSaver("scoreboard.txt");

    }

    public GameLogic getGameLogic() {
        return this.gameLogic;
    }

    private void mainMenu() {
        System.out.println("**** Main Menu ****");
        System.out.println("Choose an Option: ");
        System.out.println("Type 'Exit': Exit game - Type 'Start': Start new game - Type 'Scoreboard' - View scoreboard");
    }

    public void mainMenuExecute() {
        //this.mainMenu();
        System.out.println("**** Main Menu ****");
        System.out.println("Choose an Option: ");
        System.out.println("Type 'Exit': Exit game - Type 'Start': Start new game - Type 'Scoreboard' - View scoreboard");
        String choice = reader.nextLine();
        while (true) {
            if (choice.equals("Start")) {
                this.gameStart();
            } else if (choice.equals("Scoreboard")) {
                this.scoreBoard();
            } else if (choice.equals("Exit")) {
                this.exitGame();
                break;
            }
        }
    }

    public void gameStart() {
        System.out.println("Please enter your name: ");
        String userName = reader.nextLine();
        gameLogic.createPlayer(userName);
        //An introduction to the game
        System.out.println("Welcome to the game, " + gameLogic.getPlayer().getName() +". ");
        System.out.println("You are going to begin your very own adventure as a traveller. To travel, you first have to work. Afterwards, you can use your money to go to new places.");
        //loop starts
        while (true) {
            //work
            this.work();

            //choose a travel destination
            System.out.println("Well done on all that hard work! Next, choose a travel destination. Type the name of the destination.");
            String destinationChoice = this.destinationChoice();

            String accommodationChoice = "";
            String activityChoice = "";

            if (destinationChoice.equals("work")) {
                continue;
            }

            //int count = 1;
            //for (City c: (ArrayList<City>) gameLogic.getDestinations()) {
                //System.out.println(count + ". " + c.getName() + ". Cost: " + c.getCost());
                //count ++;
            //}

            //String destinationChoice = reader.nextLine();
            //String accommodationChoice = "";
            //String activityChoice = "";

            //int destinationCost = gameLogic.getDestination(destinationChoice).getCost();
            //if (gameLogic.getPlayer().getFunds() < destinationCost) {
                //System.out.println("Sorry, you don't have enough funds to buy that destination. Make another choice or work again. Type 'work' to work again.");
                //String workAgain = reader.nextLine();
                //if (workAgain.equals("work")) {
                    //continue;
                //} else {
                    //destinationChoice = workAgain; ///////////
                //}
            //} else {
            //choose accommodation
            System.out.println("Great choice! Next, choose your accommodation. Type the name of the accommodation to choose.");
            int accommodationCount = 1;
            for (String accommodation: gameLogic.getDestination(destinationChoice).getAccommodation().keySet()) {
                System.out.println(accommodationCount + ". " + accommodation);
                accommodationCount ++;
            }
            accommodationChoice = reader.nextLine(); ////////////////////

            //choose activity
            System.out.println("Great choice once again! Next, choose your activity. Type the name of the activity.");
            int activityCount = 1;
            for (String activity: gameLogic.getDestination(destinationChoice).getActivitiesList().keySet()) {
                System.out.println(activityCount + ". " + activity);
                activityCount ++;
            }
            activityChoice = reader.nextLine(); /////////////////////


            //pack a suitcase
            System.out.println("Great choice! Next, you have to pack your suitcase.");
            this.pack();



            //Story printout
            System.out.println("Your adventure begins!");
            System.out.println("You arrive in " + destinationChoice + ".");
            System.out.println(gameLogic.getDestination(destinationChoice).getAccommodationDescription(accommodationChoice));
            System.out.println(gameLogic.getDestination(destinationChoice).getActivityDescription(activityChoice));
            System.out.println("Wow, what a refreshing holiday.");
            System.out.println("You travel back home, to work some more and possibly see a new destination! Good luck!");

            // loop repeats
            }

        }

    private String destinationChoice() {
        while (true) {
            int count = 1;
            for (City c: (ArrayList<City>) gameLogic.getDestinations()) {
                System.out.println(count + ". " + c.getName() + ". Cost: " + c.getCost());
                count ++;
            }
            System.out.println("You have £" + gameLogic.getPlayer().getFunds() + " in funds.");
            String destinationChoice = reader.nextLine();
            int destinationCost = gameLogic.getDestination(destinationChoice).getCost();
            if (gameLogic.getPlayer().getFunds() < destinationCost) {
                System.out.println("Sorry, you don't have enough funds to buy that destination. Make another choice or work again.");
                System.out.println("You have only £" + gameLogic.getPlayer().getFunds() + " in funds.");
                System.out.println("Type 'work' to work again, or 'choose again' to choose again.");
                String option = reader.nextLine();
                if (option.equals("work")) {
                    return "work";
                } else {
                    continue;
                }
            } else {
                return destinationChoice;
            }
        }
    }


    private void pack() {
        while (true) {
            System.out.println("Type one of the following categories to pack: tops - bottoms - sun protection. To exit, type 'stop packing'.");
            String packingChoice = reader.nextLine();
            System.out.println("Next, type the name of the clothing to pack it. ");
            if (packingChoice.equals("tops")) {
                for (Clothing clothing : (ArrayList<Clothing>) gameLogic.getClothing()) {
                    if (clothing instanceof Top) {
                        System.out.println(clothing.getName());
                    }
                }
            } else if (packingChoice.equals("bottoms")) {
                for (Clothing clothing : (ArrayList<Clothing>) gameLogic.getClothing()) {
                    if (clothing instanceof Bottom) {
                        System.out.println(clothing.getName());
                    }
                }
            } else if (packingChoice.equals("sun protection")) {
                for (Clothing clothing : (ArrayList<Clothing>) gameLogic.getClothing()) {
                    if (clothing instanceof SunProtection) {
                        System.out.println(clothing.getName());
                    }
                }
            } else if (packingChoice.equals("stop packing")) {
                break;
            }

            String clothingChoice = reader.nextLine();
            //boolean clothingRecognised = false;
            for (Clothing clothing : (ArrayList<Clothing>) gameLogic.getClothing()) {
                if (clothingChoice.equals(clothing.getName())) {
                    gameLogic.pack(clothing);
                    //clothingRecognised = true;
                }
                //if (clothingRecognised == false) {
                //System.out.println("The clothing choice you put in was not recognised. Please try again.");
                ////////////will have to make the code more modular, and find a way to repeat the loop if clothing not recognised
                //}
            }
        }
        System.out.println("Your packing is all done!");
    }


    public void exitGame () {
        System.out.println("Game exited successfully.");
    }

    public void scoreBoard () {
        System.out.println("Scoreboard: ");
        String output = this.fileSaver.readFromFile();
        System.out.println(output);
    }


    private void work() {
        System.out.println("Type 'work' and press enter to work and get money! When you are ready to exit, type 'stop work'.");
        while (true) {
            String input = reader.nextLine();
            if (input.equals("stop work")) {
                break;
            }

            if (input.equals("work")) {
                gameLogic.work();
            }
        }
    }
}




