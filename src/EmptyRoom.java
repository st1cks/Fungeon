/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class EmptyRoom extends Room {

    String[] map = {
            "   ",
            "   ",
            "   "
    };

    public EmptyRoom(int x, int y) {
        super(x, y);
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
