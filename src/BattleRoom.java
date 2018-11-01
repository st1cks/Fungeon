/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class BattleRoom extends Room {

    private String[] map = {
            "   ",
            " B ",
            "   "
    };
    private String[] newMapIcon = {
            "OOO",
            "OBO",
            "OOO"
    };

    public BattleRoom(int x, int y) {
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
                " B ",
                "   "
        };
        map = oldMapIcon;
    }

    public String[] returnMapPortion() {
        return map;
    }

    public boolean deadEnd() {
        return false;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
