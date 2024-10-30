import java.util.Scanner;

public class UserInterface {
    private Scanner reader;
    private GameLogic gameLogic;
    private FileSaver fileSaver;

    public UserInterface(Scanner scanner) {
        this.reader = scanner;
        this.gameLogic = new GameLogic();
        this.fileSaver = new FileSaver("scoreboard.txt");

    }

    public void mainMenu() {
        System.out.println("Choose an Option: ");
        System.out.println("Type 'Exit' and press enter - Exit game");
        System.out.println("Type 'Start' and press enter - Start new game");
        System.out.println("Type 'Scoreboard' and press enter - View scoreboard");
    }

    public void mainMenuExecute() {
        this.mainMenu();
        String choice = reader.nextLine();
        while (true) {
            if (choice == "Start") {
                this.gameStart();
            } else if (choice == "Scoreboard") {
                this.scoreBoard();
            } else if (choice == "0") {
                this.exitGame();
            }
        }
    }

    public void gameStart() {
        System.out.println("Please enter your name: ");
        String userName = reader.nextLine();
        gameLogic.createCharacter(userName);


        }

    }

    public void exitGame() {
        System.out.println("Game exited successfully.");
    }

    public void scoreBoard() {
        System.out.println("Scoreboard: ");
        String output = this.fileSaver.readFromFile();
        System.out.println(output); //PROGRAMMING NOTES may need to move over code from filesave layer here
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        UserInterface interface = new UserInterface(reader);
    }
}
