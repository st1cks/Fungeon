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
    private String[] hiddenMap = {
            "///",
            "///",
            "///"
    };
    private String[] newMapIcon = {
            "OOO",
            "OTO",
            "OOO"
    };
    private String[] map = oldMapIcon;

    public ItemRoom(int y, int x, boolean hidden) {
        super(x, y, hidden);
    }
    public String[] returnMapPortion() {
        if (hidden) {
            return hiddenMap;
        }
        else {
            return map;
        }
    }

    public void enterRoom(Profile z) {
        occupant = z;
        z.setLocation(yLoc, xLoc);
        map = newMapIcon;
    }

    public void leaveRoom() {
        map = oldMapIcon;
    }
    public void changeMapVisiblity(boolean mapVisibility) {
        hidden = !mapVisibility;
    }

    public boolean deadEnd() {
        return true;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
