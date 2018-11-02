/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class NotAPlaceYouCanReallyGoTo extends Room {
    private String[] map = {
            "///",
            "///",
            "///"
    };
    public NotAPlaceYouCanReallyGoTo(int y, int x, boolean hidden) {
        super(x, y, hidden);
    }

    public String[] returnMapPortion() {
        return map;
    }
    public boolean enterRoom(Profile z) {
        System.out.println("felksejf");
        return false;
    }

    public boolean isAnActualRoom() {
        return false;
    }
}
