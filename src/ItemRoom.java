import java.util.Scanner;

/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class ItemRoom extends Room {
    private String[] oldMapIcon = {
            "   ",
            " T ",
            "   "
    };
    private String[] hiddenMap = {
            "///",
            "///",
            "///"
    };
    private String[] newMapIcon = {
            "OOO",
            "OTO",
            "OOO"
    };
    private Item[] commonItems = {
            new Item ("Stick", 3, 1, 10),
            new Item ("Plastic Bottle",0,1,15),
            new Item ("Very Rusty Sword",3,2,0),
    };
    private Item[] uncommonItems = {
            new Item("Pizza Cutter",4,0,8),
            new Item("Kitchen Knife",6,0,6),
            new Item("Very Heavy Rock",4,5,-10),
    };
    private Item[] rareItems = {
            new Item("Baseball Bat",5,2,8),
            new Item("Dagger",9,0,10),
            new Item("Shortsword",9,4,5),

    };
    private Item[] epicItems = {
            new Item("Gun",15,0,0),
            new Item("Longsword",13,7,0),
            new Item("Sledgehammer",25,0,-15)
    };
    private Item[] legendaryItems = {
            new Item("Rifle",35,0,-10),
            new Item("Defender Sword",25,35,-5),
            new Item("Karambit",20,0,20)
    };
    private String[] map = oldMapIcon;
    private boolean visited = false;

    public ItemRoom(int y, int x, boolean hidden) {
        super(x, y, hidden);
    }
    public String[] returnMapPortion() {
        if (hidden) {
            return hiddenMap;
        }
        else {
            return map;
        }
    }

    public boolean enterRoom(Profile z) {
        occupant = z;
        z.setLocation(yLoc, xLoc);
        hidden = false;
        map = newMapIcon;
        enterItemRoom(occupant);
        return false;
    }

    public void enterItemRoom(Profile z) {
        Item treasure = getRandomItem();
        boolean concluded = false;
        if (!visited) {
            System.out.println("You enter a room with a pedestial on the middle. On it, you find a " + treasure.name);
            System.out.println("Take the " + treasure.name + "? (y/n)");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            input.trim();
            input.toLowerCase();
            while (!concluded) {
                if (input.equals("y")) {
                    if (z.returnItem().name.toLowerCase().equals("nothing")) {
                        z.giveItem(treasure);
                        System.out.println("You take the " + treasure.name);
                    }
                    else {
                        System.out.println("You get rid of your " + z.returnItem().name + " for the " + treasure.name);
                        z.giveItem(treasure);
                    }
                    concluded = true;
                }
                if (input.equals("n")) {
                    System.out.println("You ignore the " + treasure.name + ", which disappears after you look back.");
                    concluded = true;
                }
            }
            visited = true;
        }
        else {
            System.out.println("The pedestial is still there, but whatever was on there has disappeared.");
        }
    }

    public Item getRandomItem() {
        double decider = Math.random();
        if (decider < 0.05) {
            return legendaryItems[Runner.generateRandomInteger(0,2)]; //5%
        }
        else if (decider < 0.15) {
            return epicItems[Runner.generateRandomInteger(0,2)]; // 10%
        }
        else if (decider < 0.35) {
            return rareItems[Runner.generateRandomInteger(0,2)]; //20%
        }
        else if (decider < 0.65) {
            return uncommonItems[Runner.generateRandomInteger(0,2)]; // 30%
        }
        else {
            return commonItems[Runner.generateRandomInteger(0,2)]; // 35%
        }
    }

    public void leaveRoom() {
        map = oldMapIcon;
    }
    public void changeMapVisiblity(boolean mapVisibility) {
        hidden = !mapVisibility;
    }

    public boolean deadEnd() {
        return true;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
