/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class BattleRoom extends Room {

    private String[] oldMapIcon = {
            "   ",
            " B ",
            "   "
    };
    private String[] hiddenMap = {
            "///",
            "///",
            "///"
    };
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
    private boolean visited = false;

    public BattleRoom(int y, int x, boolean hidden) {
        super(x, y, hidden);
    }

    public boolean enterRoom(Profile z) {
        occupant = z;
        z.setLocation(yLoc, xLoc);
        hidden = false;

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

    public void changeMapVisiblity(boolean mapVisibility) {
        hidden = !mapVisibility;
    }
    public boolean deadEnd() {
        return false;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
