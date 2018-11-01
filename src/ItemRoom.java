/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class ItemRoom extends Room {

    public ItemRoom(int x, int y) {
        super(x, y);
    }
    public String[] returnMapPortion() {
        String[] map = {
                "   ",
                " T ",
                "   "
        };
        return map;
    }

    public boolean deadEnd() {
        return true;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
