public class Room {
    Profile occupant; int xLoc; int yLoc;

    public Room(int x, int y) {
        xLoc = x; yLoc = y;
    }

    public void enterRoom(Profile z) {
        occupant = z;
        z.setLocation(xLoc, yLoc);
    }

    public String[] returnMapPortion() {
        String[] map = {
                "///",
                "///",
                "///"
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
