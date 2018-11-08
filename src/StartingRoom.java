/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class StartingRoom extends Room {

    private String[] oldMapIcon = {
            "   ",
            " S ",
            "   "
    };
    private String[] map = oldMapIcon;
    private String[] newMapIcon = {
            "OOO",
            "OSO",
            "OOO"
    };

    public String[] returnMapPortion() {
        return map;
    }

    public StartingRoom(int y, int x, boolean hidden) {
        super(x, y, hidden);
    }

    public boolean enterRoom(Profile z) {
        occupant = z;
        z.setLocation(yLoc, xLoc);
        map = newMapIcon;
        if (visited) {
            System.out.println("You're at the starting room, and you don't know where to go.");
        }
        else {
            System.out.println("Back at the start.");
        }
        return false;
    }

    public void leaveRoom() {
        map = oldMapIcon;
    }

    public boolean bossRoom() {
        return false;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
