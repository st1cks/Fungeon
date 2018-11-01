public class NotAPlaceYouCanReallyGoTo extends Room {
    public NotAPlaceYouCanReallyGoTo(int x, int y) {
        super(x, y);
    }

    public String[] returnMapPortion() {
        String[] map = {
                "///",
                "///",
                "///"
        };
        return map;
    }
    public boolean isAnActualRoom() {
        return false;
    }
}
