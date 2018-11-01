/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class NotAPlaceYouCanReallyGoTo extends Room {
    String[] map = {
            "///",
            "///",
            "///"
    };
    public NotAPlaceYouCanReallyGoTo(int x, int y) {
        super(x, y);
    }

    public String[] returnMapPortion() {
        return map;
    }
    public boolean isAnActualRoom() {
        return false;
    }
}
