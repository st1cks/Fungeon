public class EmptyRoom extends Room {

    public EmptyRoom(int x, int y) {
        super(x, y);
    }

    public String[] returnMapPortion() {
        String[] map = {
                "   ",
                " N ",
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
