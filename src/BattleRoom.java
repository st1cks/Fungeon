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
        Monster monster = listOfMonsters[0];
        monster.scaleStats(z.monstersKilled);
        if (!visited) {
            System.out.println("You encounter a " + monster.returnName() + "!");
            boolean concluded = false;
            while (!concluded || !z.returnDeathStatus()) {
                System.out.println("What do you do? (a)ttack/(d)efend/(i)nspect/(r)un");
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                input.toLowerCase().trim();
                if (input.equals("a")) {
                    if (monster.makeChoice().equals("a")) {

                    }
                    else {

                    }
                }
                if (input.equals("d")) {
                    if (monster.makeChoice().equals("a")) {

                    }
                    else {

                    }
                }
                if (input.equals("i")) {
                    System.out.println("You take a good look at the " + monster.returnName() + ".");
                    System.out.println("Name: " + monster.returnName());
                    System.out.println("Strength " + monster.returnStat(1));
                    System.out.println("Defence: " + monster.returnStat(2));
                    System.out.println("Speed: " + monster.returnStat(0));
                    if (monster.makeChoice().equals("a")) {

                    }
                    else {

                    }
                }
                if (input.equals("r")) {
                    double fleeChance = (double) (z.returnStat(0) / monster.returnStat(0));
                    System.out.println("You attempt to flee...");
                    double random = Math.random();
                    if (fleeChance < random) {

                    }
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
