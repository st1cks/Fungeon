/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/
import java.util.Scanner;

public class BattleRoom extends Room {

    private String[] oldMapIcon = {
            "   ",
            " B ",
            "   "
    };
    private String[] hiddenMap = {
            "///",
            "///",
            "///"
    };
    private String[] map = {
            "   ",
            " B ",
            "   "
    };
    private String[] newMapIcon = {
            "OOO",
            "OBO",
            "OOO"
    };
    private Monster[] listOfMonsters = {
            new Monster("Bad Guy",100,25,10,30),
    };

    private boolean visited = false;

    public BattleRoom(int y, int x, boolean hidden) {
        super(x, y, hidden);
    }

    public boolean enterRoom(Profile z) {
        occupant = z;
        z.setLocation(yLoc, xLoc);
        hidden = false;
        if (!visited) {
            Profile monster = listOfMonsters[0];
            System.out.println("You encounter a " + monster.returnName() + "!");
            boolean concluded = false;
            while (!concluded || !z.returnDeathStatus()) {
                System.out.println("What do you do? (a)ttack/(d)efend/(i)nspect/(r)un");
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                input.toLowerCase().trim();
                if (input.equals("a")) {

                }
            }

        }
        else {

        }
        visited = true;
        map = newMapIcon;
        return false;
    }

    public void leaveRoom() {
        map = oldMapIcon;
    }

    public String[] returnMapPortion() {
        if (hidden) {
            return hiddenMap;
        }
        else {
            return map;
        }
    }

    public void changeMapVisiblity(boolean mapVisibility) {
        hidden = !mapVisibility;
    }
    public boolean deadEnd() {
        return false;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
