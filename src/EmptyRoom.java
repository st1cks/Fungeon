/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class EmptyRoom extends Room {

    private String[] map = {
            "   ",
            "   ",
            "   "
    };
    private String[] newMapIcon = {
            "OOO",
            "O O",
            "OOO"
    };

    public EmptyRoom(int x, int y) {
        super(x, y);
    }

    public String[] returnMapPortion() {
        return map;
    }

    public void enterRoom(Profile z) {
        occupant = z;
        z.setLocation(xLoc, yLoc);
        map = newMapIcon;
    }

    public void leaveRoom() {
        String[] oldMapIcon = {
                "   ",
                "   ",
                "   "
        };
        map = oldMapIcon;
    }

    public boolean deadEnd() {
        return false;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
