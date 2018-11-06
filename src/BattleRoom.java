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
            new Monster("Goblin",50,35,17,20),
            new Monster("Imp",35,28,26,40),
            new Monster("Zombie",60,45,20,14),
    };

    private boolean visited = false;

    public BattleRoom(int y, int x, boolean hidden) {
        super(x, y, hidden);
    }

    public boolean enterRoom(Profile z) {

        map = newMapIcon;
        occupant = z;
        z.setLocation(yLoc, xLoc);
        hidden = false;
        Monster monster = listOfMonsters[Runner.generateRandomInteger(0,2)];
        monster.scaleStats(z.monstersKilled);
        if (!visited) {
            visited = true;
            System.out.println("You encounter a " + monster.returnName() + "!");
            boolean concluded = false;
            while (!concluded && !z.returnDeathStatus()) {
                int damageToMonster, damageToPlayer;
                System.out.println("=============================================================================");
                System.out.println("HP: " + z.health + " / " + z.maxHealth);
                System.out.println(monster.returnName() + "'s HP: " + monster.health + " / " + monster.maxHealth);
                System.out.println("What do you do? (A)ttack/(D)efend/(I)nspect/(R)un");

                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                input.toLowerCase().trim();

                double monsterStrength = (double) (monster.returnStat(1) / z.returnCalculatedStats(2));
                double playerStrength = (double) (z.returnCalculatedStats(1) / (monster.returnStat(2)));
                double monsterHealPower = (double) (monster.health * 0.05);
                double playerHealPower = (double) (z.health * 0.07);

                if (input.equals("a")) {
                    if (monster.makeChoice().equals("a")) {
                        damageToPlayer = Runner.generateRandomInteger((int) (Math.random() * 3.0 * monsterStrength),(int) (Math.random() * 10.0 * monsterStrength));
                        damageToMonster = Runner.generateRandomInteger((int) (Math.random() * 3.0 * playerStrength),(int) (Math.random() * 10.0 * playerStrength));
                        monster.changeHealth(-damageToMonster);
                        if (z.returnItem().name.equals("nothing")) {
                            System.out.println("You slap the " + monster.returnName() + " very hard! You deal " + damageToMonster + " damage!");
                        }
                        System.out.println("You attack the " + monster.returnName() + " with your " + z.returnItem().name + ", dealing " + damageToMonster  + " damage!");
                        if (monster.returnDeathStatus()) {
                            concluded = true;
                        }
                        else {
                            z.changeHealth(-damageToPlayer);
                            System.out.println("The " + monster.returnName() + " deals " + damageToPlayer + " damage to you.");
                        }
                    }
                    else {
                        damageToMonster = Runner.generateRandomInteger((int) (Math.random() * 1.0 * playerStrength),(int) (Math.random() * 4.0 * playerStrength));
                        monster.changeHealth((int)(monsterHealPower));
                        System.out.println("The " + monster.returnName() + " heals " + (int)(monsterHealPower) + " health by defending.");
                        monster.changeHealth(-damageToMonster);
                        System.out.println("You attack the defending " + monster.returnName() + " and only deal " + damageToMonster + " damage.");
                    }
                }
                if (input.equals("d")) {
                    if (monster.makeChoice().equals("a")) {
                        damageToPlayer = Runner.generateRandomInteger((int) (Math.random() * 1.0 * monsterStrength),(int) (Math.random() * 4.0 * monsterStrength));
                        z.changeHealth((int)(playerHealPower));
                        System.out.println("You heal " + (int)(monsterHealPower) + " health by defending.");
                        z.changeHealth(-damageToPlayer);
                        System.out.println("The " + monster.returnName() + " only deals " + damageToPlayer + " damage.");
                    }
                    else {
                        z.changeHealth((int)(playerHealPower));
                        monster.changeHealth((int)(monsterHealPower));
                        System.out.println("The " + monster.returnName() + " heals " + (int)(monsterHealPower) + " health by defending.");
                        System.out.println("You heal " + (int)(playerHealPower) + " health by defending.");
                    }
                }
                if (input.equals("i")) {
                    System.out.println("You take a good look at the " + monster.returnName() + ".");
                    System.out.println("Name: " + monster.returnName());
                    System.out.println("Strength " + monster.returnStat(1));
                    System.out.println("Defence: " + monster.returnStat(2));
                    System.out.println("Speed: " + monster.returnStat(0));
                    if (monster.makeChoice().equals("a")) {
                        damageToPlayer = Runner.generateRandomInteger((int) (Math.random() * 3.0 * monsterStrength),(int) (Math.random() * 7.0 * monsterStrength));
                        z.changeHealth(-damageToPlayer);
                        System.out.println("You took reduced damage. The " + monster.returnName() + " deals " + damageToPlayer + " damage.");
                    }
                    else {
                        monster.changeHealth((int)(monsterHealPower));
                        System.out.println("The " + monster.returnName() + " heals " + (int)(monsterHealPower) + " health by defending.");
                    }
                }
                if (input.equals("r")) {
                    int fleeChance = (100 * z.returnStat(0) / monster.returnStat(0));
                    System.out.println("You attempt to flee...");
                    int random = (int) (Math.random() * 100);
                    if (random < fleeChance) {
                        concluded = true;
                        System.out.println("You successfully flee. The " + monster.returnName() + " disappears.");
                    }
                    else {
                        System.out.println("You failed to flee...");
                        if (monster.makeChoice().equals("a")) {
                            damageToPlayer = Runner.generateRandomInteger((int) (Math.random() * 8.0 * monsterStrength),(int) (Math.random() * 15.0 * monsterStrength));;
                            z.changeHealth(-damageToPlayer);
                            System.out.println("Vulnerable, you took extra damage. The " + monster.returnName() + " dealt " + damageToPlayer + " damage.");
                        }
                        else {
                            monster.changeHealth((int)(monsterHealPower));
                            System.out.println("The " + monster.returnName() + " defended that turn, healing " + (int)(monsterHealPower) + " health.");
                        }
                    }
                }
            }
            if (monster.returnDeathStatus()) {
                System.out.println("You defeated the " + monster.returnName() + "!");
                z.changeStats((int)(Math.random() * (z.returnStat(0) * 0.1)),(int)(Math.random() * (z.returnStat(0) * 0.1)),(int)(Math.random() * (z.returnStat(0) * 0.1)));
                System.out.println("You feel yourself get a little stronger after that battle.");
                z.monstersKilled ++;
            }
            if (z.returnDeathStatus()) {
                return true;
            }
            else {
                return false;
            }

        }
        else {
            System.out.println("This room used to have something evil in it, but it's now safe.");
            return false;
        }
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
