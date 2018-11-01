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
        Room roomIQ; int randomAdjacentRoom;
        dungeon[5][5] = new StartingRoom(5, 5);

        roomIQ = dungeon[5][4]; // Generate north. North generation starts here.
        for (int i = 0; i < 3; i ++) {
            Room[] nesw = {
                    dungeon[roomIQ.xLoc][roomIQ.yLoc-1], // 1 space north of the room "In Question"
                    dungeon[roomIQ.xLoc+1][roomIQ.yLoc], // 1 space east of the room "In Question"
                    dungeon[roomIQ.xLoc][roomIQ.yLoc+1], // S.O.
                    dungeon[roomIQ.xLoc-1][roomIQ.yLoc] // W
            };
            randomAdjacentRoom = generateRandomInteger(0,3);
            while (nesw[randomAdjacentRoom] != null) {
                randomAdjacentRoom = generateRandomInteger(0,3);
            }
            roomIQ = nesw[randomAdjacentRoom];
            roomIQ = pickWhichRoomToPutIn(roomIQ.xLoc, roomIQ.yLoc);
            if (roomIQ.deadEnd()) {
                break;
            }
        }

        roomIQ = dungeon[6][5]; // Generate to the east.
        for (int i = 0; i < 3; i ++) {
            Room[] nesw = {
                    dungeon[roomIQ.xLoc][roomIQ.yLoc-1], // 1 space north of the room "In Question"
                    dungeon[roomIQ.xLoc+1][roomIQ.yLoc], // 1 space east of the room "In Question"
                    dungeon[roomIQ.xLoc][roomIQ.yLoc+1], // S.O.
                    dungeon[roomIQ.xLoc-1][roomIQ.yLoc] // W
            };
            randomAdjacentRoom = generateRandomInteger(0,3);
            while (nesw[randomAdjacentRoom] != null) {
                randomAdjacentRoom = generateRandomInteger(0,3);
            }
            roomIQ = nesw[randomAdjacentRoom];
            roomIQ = pickWhichRoomToPutIn(roomIQ.xLoc, roomIQ.yLoc);
            if (roomIQ.deadEnd()) {
                break;
            }
        }

        roomIQ = dungeon[5][6]; // South
        for (int i = 0; i < 3; i ++) {
            Room[] nesw = {
                    dungeon[roomIQ.xLoc][roomIQ.yLoc-1], // 1 space north of the room "In Question"
                    dungeon[roomIQ.xLoc+1][roomIQ.yLoc], // 1 space east of the room "In Question"
                    dungeon[roomIQ.xLoc][roomIQ.yLoc+1], // S.O.
                    dungeon[roomIQ.xLoc-1][roomIQ.yLoc] // W
            };
            randomAdjacentRoom = generateRandomInteger(0,3);
            while (nesw[randomAdjacentRoom] != null) {
                randomAdjacentRoom = generateRandomInteger(0,3);
            }
            roomIQ = nesw[randomAdjacentRoom];
            roomIQ = pickWhichRoomToPutIn(roomIQ.xLoc, roomIQ.yLoc);
            if (roomIQ.deadEnd()) {
                break;
            }
        }

        roomIQ = dungeon[4][5]; // West
        for (int i = 0; i < 3; i ++) {
            Room[] nesw = {
                    dungeon[roomIQ.xLoc][roomIQ.yLoc-1], // 1 space north of the room "In Question"
                    dungeon[roomIQ.xLoc+1][roomIQ.yLoc], // 1 space east of the room "In Question"
                    dungeon[roomIQ.xLoc][roomIQ.yLoc+1], // S.O.
                    dungeon[roomIQ.xLoc-1][roomIQ.yLoc] // W
            };
            randomAdjacentRoom = generateRandomInteger(0,3);
            while (nesw[randomAdjacentRoom] != null) {
                randomAdjacentRoom = generateRandomInteger(0,3);
            }
            roomIQ = nesw[randomAdjacentRoom];
            roomIQ = pickWhichRoomToPutIn(roomIQ.xLoc, roomIQ.yLoc);
            if (roomIQ.deadEnd()) {
                break;
            }
        }
        return dungeon;
    }

    public static int generateRandomInteger(int min, int max) {
        return (int) (Math.random() * ((max + 1) - min)) + min;
    }

    public static Room pickWhichRoomToPutIn(int x, int y) {
        int decider = generateRandomInteger(0,3);
        if (decider == 3) {
            return new ItemRoom(x, y);
        }
        else if (decider == 2) {
            return new EmptyRoom(x, y);
        }
        else {
            return new BattleRoom(x, y);
        }
    }

    public static void printMainScreen() {

    }

    public static void printMap(Room[][] map) {
        System.out.println("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗"); // FIRST ROW - BORDER
    }

}
