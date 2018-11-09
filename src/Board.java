public class Board {

    private Room[][] dungeon;

    public Board(int length, int width) {
        // So you're probably wondering why the length and the width of the space are inputs. And to tell you the truth,
        // I don't really know exactly why this happens, but this method doesn't recognize Room[][] field (above) as a
        // real variable, so to fix that I just decided to make another room[][] array in here and set it to field[][].
        dungeon = new Room[length][width];
        Room roomIQ; int randomAdjacentRoom;
        // roomIQ stands for "Room In Question". It's very important in this method, you'll see why.

        for (int i = 0; i < dungeon.length; i ++) {
            for (int j = 0; j < dungeon[i].length; j ++) {
                dungeon[i][j] = new NotAPlaceYouCanReallyGoTo(j, i, false);
                // Fills the whole dungeon with walls, to create a clean slate to work on.
            }
        }
        dungeon[length/2][width/2] = new StartingRoom(length/2, width/2, false);
        // Creates the start room in the absolute middle of the dungeon.

        roomIQ = dungeon[4][5];
        roomIQ = pickWhichRoomToPutIn(roomIQ.yLoc, roomIQ.xLoc);
        // By setting "roomIQ" to a space in the dungeon, I'm essentially "selecting" this piece of the dungeon to work
        // on.
        for (int i = 0; i < length / 2 - 1; i ++) {
            dungeon[roomIQ.yLoc][roomIQ.xLoc] = pickWhichRoomToPutIn(roomIQ.yLoc, roomIQ.xLoc);
            Room[] nesw = {
                    dungeon[roomIQ.yLoc-1][roomIQ.xLoc], // 1 space north of the room "In Question"
                    dungeon[roomIQ.yLoc][roomIQ.xLoc+1], // 1 space east of the room "In Question"
                    dungeon[roomIQ.yLoc+1][roomIQ.xLoc], // S.O.
                    dungeon[roomIQ.yLoc][roomIQ.xLoc-1]  // W
            };
            // nesw[] refers to every room that is directly N, E, S, and W of the room in question. This is to find
            // out which spaces are unused and therefore can have something generated on it.
            if (nesw[0].isAnActualRoom() && nesw[1].isAnActualRoom() && nesw[2].isAnActualRoom() && nesw[3].isAnActualRoom()) {
                break;
                // And if all surrounding rooms are used, just end it and move on to another direction.
            }
            randomAdjacentRoom = Runner.generateRandomInteger(0,3);
            while (nesw[randomAdjacentRoom].isAnActualRoom()) {
                // So this "while" statement makes the program re-choose an adjacent room until it finds one that is
                // unused, if the one selected happens to be used.
                randomAdjacentRoom = Runner.generateRandomInteger(0,3);
            }
            roomIQ = nesw[randomAdjacentRoom];
            dungeon[roomIQ.yLoc][roomIQ.xLoc] = pickWhichRoomToPutIn(roomIQ.yLoc, roomIQ.xLoc);
            // Picks what type of room will be placed in this spot.
        }
        // The other three copies of the code below are the exact same thing, in different directions.
        roomIQ = dungeon[5][6]; // Generate to the east.
        roomIQ = pickWhichRoomToPutIn(roomIQ.yLoc, roomIQ.xLoc);
        for (int i = 0; i < width / 2 - 1; i ++) {
            dungeon[roomIQ.yLoc][roomIQ.xLoc] = pickWhichRoomToPutIn(roomIQ.yLoc, roomIQ.xLoc);
            Room[] nesw = {
                    dungeon[roomIQ.yLoc-1][roomIQ.xLoc], // 1 space north of the room "In Question"
                    dungeon[roomIQ.yLoc][roomIQ.xLoc+1], // 1 space east of the room "In Question"
                    dungeon[roomIQ.yLoc+1][roomIQ.xLoc], // S.O.
                    dungeon[roomIQ.yLoc][roomIQ.xLoc-1]  // W
            };
            if (nesw[0].isAnActualRoom() && nesw[1].isAnActualRoom() && nesw[2].isAnActualRoom() && nesw[3].isAnActualRoom()) {
                break;
            }
            randomAdjacentRoom = Runner.generateRandomInteger(0,3);
            while (nesw[randomAdjacentRoom].isAnActualRoom()) {
                randomAdjacentRoom = Runner.generateRandomInteger(0,3);
            }
            roomIQ = nesw[randomAdjacentRoom];
            dungeon[roomIQ.yLoc][roomIQ.xLoc] = pickWhichRoomToPutIn(roomIQ.yLoc, roomIQ.xLoc);
        }

        roomIQ = dungeon[6][5]; // South
        roomIQ = pickWhichRoomToPutIn(roomIQ.yLoc, roomIQ.xLoc);
        for (int i = 0; i < length / 2 - 1; i ++) {
            dungeon[roomIQ.yLoc][roomIQ.xLoc] = pickWhichRoomToPutIn(roomIQ.yLoc, roomIQ.xLoc);
            Room[] nesw = {
                    dungeon[roomIQ.yLoc-1][roomIQ.xLoc], // 1 space north of the room "In Question"
                    dungeon[roomIQ.yLoc][roomIQ.xLoc+1], // 1 space east of the room "In Question"
                    dungeon[roomIQ.yLoc+1][roomIQ.xLoc], // S.O.
                    dungeon[roomIQ.yLoc][roomIQ.xLoc-1]  // W
            };
            if (nesw[0].isAnActualRoom() && nesw[1].isAnActualRoom() && nesw[2].isAnActualRoom() && nesw[3].isAnActualRoom()) {
                break;
            }
            randomAdjacentRoom = Runner.generateRandomInteger(0,3);
            while (nesw[randomAdjacentRoom].isAnActualRoom()) {
                randomAdjacentRoom = Runner.generateRandomInteger(0,3);
            }
            roomIQ = nesw[randomAdjacentRoom];
            dungeon[roomIQ.yLoc][roomIQ.xLoc] = pickWhichRoomToPutIn(roomIQ.yLoc, roomIQ.xLoc);
        }

        roomIQ = dungeon[5][4]; // West
        roomIQ = pickWhichRoomToPutIn(roomIQ.yLoc, roomIQ.xLoc);
        for (int i = 0; i < width / 2 - 1; i ++) {
            dungeon[roomIQ.yLoc][roomIQ.xLoc] = pickWhichRoomToPutIn(roomIQ.yLoc, roomIQ.xLoc);
            Room[] nesw = {
                    dungeon[roomIQ.yLoc-1][roomIQ.xLoc], // 1 space north of the room "In Question"
                    dungeon[roomIQ.yLoc][roomIQ.xLoc+1], // 1 space east of the room "In Question"
                    dungeon[roomIQ.yLoc+1][roomIQ.xLoc], // S.O.
                    dungeon[roomIQ.yLoc][roomIQ.xLoc-1]  // W
            };
            if (nesw[0].isAnActualRoom() && nesw[1].isAnActualRoom() && nesw[2].isAnActualRoom() && nesw[3].isAnActualRoom()) {
                break;
            }
            randomAdjacentRoom = Runner.generateRandomInteger(0,3);
            while (nesw[randomAdjacentRoom].isAnActualRoom()) {
                randomAdjacentRoom = Runner.generateRandomInteger(0,3);
            }
            roomIQ = nesw[randomAdjacentRoom];
            dungeon[roomIQ.yLoc][roomIQ.xLoc] = pickWhichRoomToPutIn(roomIQ.yLoc, roomIQ.xLoc);

        }
        for (int i = 0; i < length; i ++) {
            if (dungeon[0][i].isAnActualRoom()) {
                dungeon[0][i] = new NotAPlaceYouCanReallyGoTo(0, i, true);
            }
            if (dungeon[i][0].isAnActualRoom()) {
                dungeon[i][0] = new NotAPlaceYouCanReallyGoTo(i, 0, true);
            }
        }
        int adjacentRooms = 0;
        while (adjacentRooms == 0) {
            roomIQ = dungeon[Runner.generateRandomInteger(2,dungeon.length-2)][Runner.generateRandomInteger(2,dungeon[0].length-2)];
            boolean[] neswBoolean = {
                    dungeon[roomIQ.yLoc-1][roomIQ.xLoc].isAnActualRoom(), // 1 space north of the room "In Question"
                    dungeon[roomIQ.yLoc][roomIQ.xLoc+1].isAnActualRoom(), // 1 space east of the room "In Question"
                    dungeon[roomIQ.yLoc+1][roomIQ.xLoc].isAnActualRoom(), // S.O.
                    dungeon[roomIQ.yLoc][roomIQ.xLoc-1].isAnActualRoom()
            };
            adjacentRooms = 0;
            for (int i = 1; i < neswBoolean.length; i ++) {
                if (neswBoolean[i]) {
                    adjacentRooms ++;
                }
            }
        }
        dungeon[roomIQ.yLoc][roomIQ.xLoc] = new BossRoom(roomIQ.yLoc, roomIQ.xLoc,false);
    }

    public Room pickWhichRoomToPutIn(int y, int x) {
        int decider = Runner.generateRandomInteger(0,9);
        if (decider < 2) {
            return new ItemRoom(y, x, true);
        }
        else if (decider < 4) {
            return new EmptyRoom(y, x, true);
        }
        else {
            return new BattleRoom(y, x, true);
        }
    }

    public Room getRoom(int x, int y) {
        return dungeon[x][y];
    }

    public Room[][] returnField() {
        return dungeon;
    }

    public void printMap(Profile profile) {
        String x = "  ";
        for (int i = 0; i < dungeon.length; i ++) {
            x += i + "   ";
        }
        System.out.println(x);

        String y = "╔";
        for (int i = 0; i < dungeon.length; i ++) {
            if (i != dungeon.length-1) {y += "═══╦";}
            else {y += "═══╗";}
        }
        System.out.println(y);

        for (int i = 0; i < dungeon.length; i ++) {
            for (int j = 0; j < 3; j ++) {
                String z = "";
                for (int k = 0; k < dungeon[i].length; k ++) {
                    z += "║" + dungeon[k][i].returnMapPortion()[j];
                }
                z += "║";
                if (j == 1) {
                    z += "  " + i;
                }
                System.out.println(z);
            }
            if (i != dungeon.length - 1) {
                String a = "╠";
                for (int j = 0; j < dungeon.length; j ++) {
                    if (j != dungeon.length - 1) {
                        a += "═══╬";
                    }
                    else {
                        a += "═══╣";
                    }
                }
                System.out.println(a);
            }
        }
        String b = "╚";
        for (int i = 0; i < dungeon[0].length; i ++) {
            if (i != dungeon.length - 1) {
                b += "═══╩";
            }
            else {
                b += "═══╝";
            }
        }
        System.out.println(b);
        System.out.println("You are located in " + profile.returnLocation()[1] + ", " + profile.returnLocation()[0]);
    }
}
