import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        boolean gameRunning = true;
        int OVERWORLD = 0; int BATTLE = 1;
        int gameState;

        // The character creation process, based on Profile class. The only real input the user has is with
        // their name.
        System.out.println("Welcome, enter your name.");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        Profile you = new Profile(input, 5, 5);


        int fieldLength = 11; int fieldWidth = 11;

        Room[][] field = randomGenerateField(11,11);

        while (gameRunning) {

        }


    }

    public static Room[][] randomGenerateField(int length, int width) {
        Room[][] dungeon = new Room[length][width];
        dungeon[5][5] =
    }

    public static int generateRandomInteger(int min, int max) {
        return (int) (Math.random() * ((max + 1) - min)) + min;
    }

    public static void printMainScreen() {

    }

}
