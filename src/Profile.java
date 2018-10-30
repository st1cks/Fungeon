public class Profile {
    String name;
    int xLoc; int yLoc;

    public Profile(String name, int x, int y) {
        this.name = name;
        this.xLoc = x;
        this.yLoc = y;
    }

    public void move(int x, int y) {
        xLoc += x;
        yLoc += y;
    }

    public void setLocation(int x, int y){
        xLoc = x;
        yLoc = y;
    }

    public int[] returnLocation() {
        int[] z = {xLoc, yLoc};
        return z;
    }

}
