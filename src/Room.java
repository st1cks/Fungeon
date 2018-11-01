public class Room {
    Profile occupant; int xLoc; int yLoc;

    public Room(int x, int y, Profile z) {
        xLoc = x; yLoc = y; occupant = z;
    }

    public String[] returnMapPortion() {
        String[] map = {
                "///",
                "///",
                "///"
        };
        return map;
    }

}
