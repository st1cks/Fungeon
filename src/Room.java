/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class Room {
    Profile occupant; int xLoc; int yLoc; boolean hidden; boolean visited;
    private String[] oldMapIcon = {
            "   ",
            "   ",
            "   "
    };
    private String[] newMapIcon = {
            "   ",
            "   ",
            "   ",
    };
    private String[] hiddenMap = {
            "///",
            "///",
            "///"
    };
    private String[] map = {
            "   ",
            "   ",
            "   "
    };

    public Room(int y, int x, boolean hidden) {
        xLoc = x; yLoc = y; this.hidden = hidden;
    }

    public boolean enterRoom(Profile z) {
        occupant = z;
        z.setLocation(yLoc, xLoc);
        hidden = false;
        visited = true;
        map = newMapIcon;
        return false;
    }
    public void leaveRoom() {
        map = oldMapIcon;
    }

    public String[] returnMapPortion() {
        if (hidden) {
            return hiddenMap;
        }
        else {
            return map;
        }
    }

    public boolean bossRoom() {
        return false;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
