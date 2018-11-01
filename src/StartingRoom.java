/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class StartingRoom extends Room {

    public String[] returnMapPortion() {
        String[] map = {
                "   ",
                " S ",
                "   "
        };
        return map;
    }

    public StartingRoom(int x, int y) {
        super(x, y);
    }

    public void enterRoom(Profile z) {
        String[] newMapIcon = {
                "OOO",
                "OSO",
                "OOO"
        };
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
