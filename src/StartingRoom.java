/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class StartingRoom extends Room {

    public StartingRoom(int x, int y) {
        super(x, y);
    }

    public String[] returnMapPortion() {
        String[] map = {
                "   ",
                " S ",
                "   "
        };
        return map;
    }
    public boolean deadEnd() {
        return false;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
