/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class Room {
    Profile occupant; int xLoc; int yLoc;

    public Room(int x, int y) {
        xLoc = x; yLoc = y;
    }

    public void enterRoom(Profile z) {
        occupant = z;
        z.setLocation(xLoc, yLoc);
    }

    public String[] returnMapPortion() {
        String[] map = {
                "///",
                "///",
                "///"
        };
        return map;
    }

    public boolean deadEnd() {
        return false;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
