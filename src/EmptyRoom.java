public class EmptyRoom extends Room {

    public EmptyRoom(int x, int y) {
        super(x, y);
    }

    public String[] returnMapPortion() {
        String[] map = {
                "   ",
                "   ",
                "   "
        };
        return map;
    }

    public boolean deadEnd() {
        return false;
    }
}
