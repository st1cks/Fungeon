/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class StartingRoom extends Room {

    private String[] oldMapIcon = {
            "   ",
            " S ",
            "   "
    };
    private String[] map = oldMapIcon;
    private String[] newMapIcon = {
            "OOO",
            "OSO",
            "OOO"
    };

    public String[] returnMapPortion() {
        return map;
    }

    public StartingRoom(int y, int x, boolean hidden) {
        super(x, y, hidden);
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
