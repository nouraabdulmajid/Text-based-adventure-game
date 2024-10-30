import java.util.Scanner;

public class UserInterface {
    private Scanner reader;

    public UserInterface() {
        this.reader = new Scanner(System.in);
    }

    public void mainMenu() {
        System.out.println("Choose an Option: ");
        System.out.println("Enter - Start game");
        System.out.println("Esc - Exit game");
        System.out.println("Space - View leaderboard");
    }

    public void mainMenuExecute() {
        this.mainMenu();
        String choice = reader.nextLine();
        if (choice == "/n") {
            this.levelOne(); // or maybe logic layer level
        } else if (choice == " ") { // escape key?
            // code to close the screen
        } else if (choice == " ") {
            this.leaderBoard() // this will involve the fileSave layer
        }
    }

    public static void main(String[] args) {
        UserInterface interface = new UserInterface();
    }
}
