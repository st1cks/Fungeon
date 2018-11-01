/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class StartingRoom extends Room {

    private String[] map = {
            "   ",
            " S ",
            "   "
    };
    private String[] newMapIcon = {
            "OOO",
            "OSO",
            "OOO"
    };

    public String[] returnMapPortion() {
        return map;
    }

    public StartingRoom(int x, int y) {
        super(x, y);
    }

    public void enterRoom(Profile z) {
        occupant = z;
        z.setLocation(xLoc, yLoc);
        map = newMapIcon;
    }

    public void leaveRoom() {
        String[] oldMapIcon = {
                "   ",
                " S ",
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
