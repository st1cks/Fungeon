public class BattleRoom extends Room {

    public BattleRoom(int x, int y) {
        super(x, y);
    }

    public String[] returnMapPortion() {
        String[] map = {
                "   ",
                " B ",
                "   "
        };
        return map;
    }

    public boolean deadEnd() {
        return false;
    }
}
