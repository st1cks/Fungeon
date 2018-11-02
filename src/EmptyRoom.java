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
    private String[] oldMapIcon = {
            "   ",
            "   ",
            "   "
    };

    public EmptyRoom(int y, int x) {
        super(x, y);
    }
    private String[] map = oldMapIcon;

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
        return false;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
