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
}
