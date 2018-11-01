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
        printMap(field);


        while (gameRunning) {

        }


    }

    public static Room[][] randomGenerateField(int length, int width) {
        Room[][] dungeon = new Room[length][width];
        Room roomIQ; int randomAdjacentRoom;

        for (int i = 0; i < dungeon.length; i ++) {
            for (int j = 0; j < dungeon[i].length; j ++) {
                dungeon[i][j] = new NotAPlaceYouCanReallyGoTo(i, j);
            }
        }
        dungeon[5][5] = new StartingRoom(5, 5);

        roomIQ = dungeon[5][4]; // Generate north. North generation starts here.
        for (int i = 0; i < 3; i ++) {
            dungeon[roomIQ.xLoc][roomIQ.yLoc] = pickWhichRoomToPutIn(roomIQ.xLoc, roomIQ.yLoc);
            Room[] nesw = {
                    dungeon[roomIQ.xLoc][roomIQ.yLoc-1], // 1 space north of the room "In Question"
                    dungeon[roomIQ.xLoc+1][roomIQ.yLoc], // 1 space east of the room "In Question"
                    dungeon[roomIQ.xLoc][roomIQ.yLoc+1], // S.O.
                    dungeon[roomIQ.xLoc-1][roomIQ.yLoc] // W
            };
            randomAdjacentRoom = generateRandomInteger(0,3);
            while (nesw[randomAdjacentRoom].isAnActualRoom()) {
                randomAdjacentRoom = generateRandomInteger(0,3);
                if (nesw[0].isAnActualRoom() && nesw[1].isAnActualRoom() && nesw[2].isAnActualRoom() && nesw[3].isAnActualRoom()) {
                    break;
                }
            }
            roomIQ = nesw[randomAdjacentRoom];
            dungeon[roomIQ.xLoc][roomIQ.yLoc] = pickWhichRoomToPutIn(roomIQ.xLoc, roomIQ.yLoc);
            if (roomIQ.deadEnd()) {
                break;
            }
        }

        roomIQ = dungeon[6][5]; // Generate to the east.
        for (int i = 0; i < 3; i ++) {
            dungeon[roomIQ.xLoc][roomIQ.yLoc] = pickWhichRoomToPutIn(roomIQ.xLoc, roomIQ.yLoc);
            Room[] nesw = {
                    dungeon[roomIQ.xLoc][roomIQ.yLoc-1], // 1 space north of the room "In Question"
                    dungeon[roomIQ.xLoc+1][roomIQ.yLoc], // 1 space east of the room "In Question"
                    dungeon[roomIQ.xLoc][roomIQ.yLoc+1], // S.O.
                    dungeon[roomIQ.xLoc-1][roomIQ.yLoc] // W
            };
            randomAdjacentRoom = generateRandomInteger(0,3);
            while (nesw[randomAdjacentRoom].isAnActualRoom()) {
                randomAdjacentRoom = generateRandomInteger(0,3);
                if (nesw[0].isAnActualRoom() && nesw[1].isAnActualRoom() && nesw[2].isAnActualRoom() && nesw[3].isAnActualRoom()) {
                    break;
                }
            }
            roomIQ = nesw[randomAdjacentRoom];
            dungeon[roomIQ.xLoc][roomIQ.yLoc] = pickWhichRoomToPutIn(roomIQ.xLoc, roomIQ.yLoc);
            if (roomIQ.deadEnd()) {
                break;
            }
        }

        roomIQ = dungeon[5][6]; // South
        for (int i = 0; i < 3; i ++) {
            dungeon[roomIQ.xLoc][roomIQ.yLoc] = pickWhichRoomToPutIn(roomIQ.xLoc, roomIQ.yLoc);
            Room[] nesw = {
                    dungeon[roomIQ.xLoc][roomIQ.yLoc-1], // 1 space north of the room "In Question"
                    dungeon[roomIQ.xLoc+1][roomIQ.yLoc], // 1 space east of the room "In Question"
                    dungeon[roomIQ.xLoc][roomIQ.yLoc+1], // S.O.
                    dungeon[roomIQ.xLoc-1][roomIQ.yLoc] // W
            };
            randomAdjacentRoom = generateRandomInteger(0,3);
            while (nesw[randomAdjacentRoom].isAnActualRoom()) {
                randomAdjacentRoom = generateRandomInteger(0,3);
                if (nesw[0].isAnActualRoom() && nesw[1].isAnActualRoom() && nesw[2].isAnActualRoom() && nesw[3].isAnActualRoom()) {
                    break;
                }
            }
            roomIQ = nesw[randomAdjacentRoom];
            dungeon[roomIQ.xLoc][roomIQ.yLoc] = pickWhichRoomToPutIn(roomIQ.xLoc, roomIQ.yLoc);
            if (roomIQ.deadEnd()) {
                break;
            }
        }

        roomIQ = dungeon[4][5]; // West
        for (int i = 0; i < 3; i ++) {
            dungeon[roomIQ.xLoc][roomIQ.yLoc] = pickWhichRoomToPutIn(roomIQ.xLoc, roomIQ.yLoc);
            Room[] nesw = {
                    dungeon[roomIQ.xLoc][roomIQ.yLoc-1], // 1 space north of the room "In Question"
                    dungeon[roomIQ.xLoc+1][roomIQ.yLoc], // 1 space east of the room "In Question"
                    dungeon[roomIQ.xLoc][roomIQ.yLoc+1], // S.O.
                    dungeon[roomIQ.xLoc-1][roomIQ.yLoc] // W
            };
            randomAdjacentRoom = generateRandomInteger(0,3);
            while (nesw[randomAdjacentRoom].isAnActualRoom()) {
                randomAdjacentRoom = generateRandomInteger(0,3);
                if (nesw[0].isAnActualRoom() && nesw[1].isAnActualRoom() && nesw[2].isAnActualRoom() && nesw[3].isAnActualRoom()) {
                    break;
                }
            }
            roomIQ = nesw[randomAdjacentRoom];
            dungeon[roomIQ.xLoc][roomIQ.yLoc] = pickWhichRoomToPutIn(roomIQ.xLoc, roomIQ.yLoc);
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
        for (int i = 0; i < map.length; i ++) {
            for (int j = 0; j < 3; j ++) {
                String x = "";
                for (int k = 0; k < map[i].length; k ++) {
                    x += "║" + map[i][k].returnMapPortion()[j];
                }
                x += "║";
                System.out.println(x);
            }
            if (i != map.length - 1) {
                System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
            }
        }
        System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
    }

}