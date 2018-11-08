/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class EmptyRoom extends Room {
    private String[] newMapIcon = {
            "OOO",
            "O O",
            "OOO"
    };
    private String[] hiddenMap = {
            "///",
            "///",
            "///"
    };
    private String[] oldMapIcon = {
            "   ",
            "   ",
            "   "
    };
    private boolean visited = false;

    public EmptyRoom(int y, int x, boolean hidden) {
        super(x, y, hidden);
    }
    private String[] map = oldMapIcon;

    public String[] returnMapPortion() {
        if (hidden) {
            return hiddenMap;
        }
        else {
            return map;
        }
    }

    public boolean enterRoom(Profile z) {
        occupant = z;
        z.setLocation(yLoc, xLoc);
        hidden = false;
        map = newMapIcon;
        if (!visited) {
            System.out.println("Wow, this room has nothing in it.");
        }
        else {
            System.out.println("I can't believe it! There's still nothing in this room!");
        }
        return false;
    }

    public void leaveRoom() {
        map = oldMapIcon;
    }

    public boolean bossRoom() {
        return false;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
