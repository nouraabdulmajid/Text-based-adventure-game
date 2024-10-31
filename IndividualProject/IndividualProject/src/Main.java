import domain.*;
import presentation.*;
import application.*;
//import fileSaver.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // initialise the UI
        Scanner reader = new Scanner(System.in);
        UserInterface ui = new UserInterface(reader);

        ui.mainMenuExecute();




    }
}
