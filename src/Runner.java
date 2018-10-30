import java.util.Scanner;
public class Runner {
    public static void main(String[] args) {
        System.out.println("Welcome, enter your name.");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        Profile you = new Profile(input, 0, 0);
        int fieldLength = 25; int fieldWidth = 25;

        Room[][] field = new Room[fieldLength][fieldWidth];

        for (int i = 0; i < fieldLength; i ++) {
            for (int j = 0; j < fieldWidth; j ++) {
                field[i][j] = new Room(i, j);
            }
        }
    }

}
