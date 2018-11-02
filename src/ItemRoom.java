/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class ItemRoom extends Room {
    private String[] oldMapIcon = {
            "   ",
            " T ",
            "   "
    };
    private String[] newMapIcon = {
            "OOO",
            "OTO",
            "OOO"
    };
    private String[] map = oldMapIcon;

    public ItemRoom(int y, int x) {
        super(x, y);
    }
    public String[] returnMapPortion() {
        return map;
    }

    public void enterRoom(Profile z) {
        occupant = z;
        z.setLocation(yLoc, xLoc);
        map = newMapIcon;
    }

    public void leaveRoom() {
        map = oldMapIcon;
    }

    public boolean deadEnd() {
        return true;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
