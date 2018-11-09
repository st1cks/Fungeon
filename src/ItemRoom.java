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
            new Item ("Stick", 5, 1, 10),
            new Item ("Plastic Bottle",2,2,15),
            new Item ("Very Rusty Sword",8,3,0),
    };
    private Item[] uncommonItems = {
            new Item("Pizza Cutter",7,0,8),
            new Item("Kitchen Knife",9,0,6),
            new Item("Very Heavy Rock",13,12,-10),
    };
    private Item[] rareItems = {
            new Item("Baseball Bat",12,7,8),
            new Item("Dagger",15,0,10),
            new Item("Shortsword",14,4,5),

    };
    private Item[] epicItems = {
            new Item("Pistol",28,0,0),
            new Item("Longsword",27,12,0),
            new Item("Sledgehammer",36,0,-15)
    };
    private Item[] legendaryItems = {
            new Item("Rifle",50,0,-10),
            new Item("Defender Sword",30,60,-5),
            new Item("Karambit",35,0,20)
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
        hidden = false;
        Item treasure = getRandomItem();
        boolean concluded = false;
        if (!visited) {
            System.out.println("You enter a room with a pedestial on the middle. On it, you find a " + treasure.name);
            System.out.println("Take the " + treasure.name + "? (y/n)");
            while (!concluded) {
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                input.trim();
                input.toLowerCase();
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

    public Item getRandomItem() { // Takes a random group of items based on chance, and a random item from that group.
        double decider = Math.random();
        if (decider < 0.1) {
            return legendaryItems[Runner.generateRandomInteger(0,legendaryItems.length-1)]; // 10%
        }
        else if (decider < 0.26) {
            return epicItems[Runner.generateRandomInteger(0,epicItems.length-1)]; // 16%
        }
        else if (decider < 0.4) {
            return rareItems[Runner.generateRandomInteger(0,rareItems.length-1)]; // 24%
        }
        else if (decider < 0.66) {
            return uncommonItems[Runner.generateRandomInteger(0,uncommonItems.length-1)]; // 26%
        }
        else {
            return commonItems[Runner.generateRandomInteger(0,commonItems.length-1)]; // 33%
        }
    }

    public void leaveRoom() {
        map = oldMapIcon;
    }

    public boolean bossRoom() {
        return false;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
