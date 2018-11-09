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
        System.out.println("felksejf"); // This class is a wall. If you somehow get inside the wall, it will print out this debug message.
        return false;
    }

    public boolean isAnActualRoom() {
        return false;
    }
}
