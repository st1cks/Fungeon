import java.util.Scanner;

public class BossRoom extends Room {
    public BossRoom(int y, int x, boolean hidden) {
        super(x, y, hidden);
    }
    private String[] map = {
            "   ",
            " X ",
            "   "
    };
    private String[] newMapIcon = {
            "OOO",
            "OXO",
            "OOO"
    };
    private Monster[] listOfSummons = {
            new Monster("Bad Guy 1",30,50,50,100),
            new Monster("Bad Guy 2",70,25,25,100),
            new Monster("Bad Guy 3", 20,90,25,100)
    };
    private boolean visited = false;

    public boolean enterRoom(Profile z) {
        boolean concluded = false;
        map = newMapIcon;
        visited = true;
        z.setLocation(yLoc, xLoc);
        Boss boss = new Boss("Lord of the Bad People",250,60,60,100);
        boss.scaleStats(z.getMonstersKilled());
        z.changeStats((int) (z.returnStat(0) * 0.50), (int) (z.returnStat(1) * 0.50), (int) (z.returnStat(2) * 0.50));
        System.out.println("The door shuts behind you, and you are now locked in a battle with " + boss.returnName() + ".");
        while (!concluded && !z.returnDeathStatus()) {
            int damageToBoss, damageToPlayer;
            System.out.println("=============================================================================");
            System.out.println("HP: " + z.health + " / " + z.maxHealth);
            System.out.println(boss.returnName() + "'s HP: " + boss.health + " / " + boss.maxHealth);
            System.out.println("What do you do? (A)ttack/(D)efend/(I)nspect");

            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            input = input.trim().toLowerCase();

            String bossInput = boss.makeChoice();
            while (boss.health == boss.maxHealth && bossInput.equals("d")) {
                bossInput = boss.makeChoice();
            }
            double bossStrength = (double)(boss.returnStat(1) / z.returnCalculatedStats(2));
            double playerStrength = (double)(z.returnCalculatedStats(1) / boss.returnStat(2));
            int playerHealPower = (int) (z.health * 0.25);

            if (bossStrength < 1.0) {
                bossStrength = 1.0;
            }
            if (playerStrength < 1.0) {
                playerStrength = 1.0;
            }

            if (bossInput.equals("a")) {
                if (input.equals("a")) {
                    System.out.println("You both charge for each other!");
                    damageToBoss = Runner.generateRandomInteger((int) (8.0 * playerStrength),(int) (15.0 * playerStrength));
                    damageToPlayer = Runner.generateRandomInteger((int) (8.0 * bossStrength),(int) (15.0 * bossStrength));
                    boss.changeHealth(-damageToBoss);
                    System.out.println("You attack the " + boss.returnName() + " for " + damageToBoss + " damage!");
                    if (!boss.returnDeathStatus()) {
                        z.changeHealth(-damageToPlayer);
                        System.out.println("The " + boss.returnName() + " deals " + damageToPlayer + " damage to you.");
                    }
                }
                if (input.equals("d")) {
                    System.out.println("You took a defensive stance, but you're ready to absorb the blow of the " + boss.returnName() + "!");

                }
                if (input.equals("i")) {

                }
            }
            if (bossInput.equals("d")) {
                System.out.println("The " + boss.returnName() + " took a defensive stance, reflecting your attacks!");
                if (input.equals("a")) {
                    System.out.println("You fall right for the counter!");
                    damageToBoss = Runner.generateRandomInteger((int) (6.0 * playerStrength),(int) (10.0 * playerStrength));
                    damageToPlayer = (int) (damageToBoss * 0.25);
                    System.out.println("You attacked the " + boss.returnName() + " and dealt " + damageToBoss + " damage!");
                    System.out.println("You suffered " + damageToPlayer + " recoil damage.");
                    boss.changeHealth(-damageToBoss);
                    z.changeHealth(-damageToPlayer);
                }
                if (input.equals("d")) {
                    System.out.println("The " + boss.returnName() + " expected an attack, but you called its bluff!");
                    z.changeHealth(playerHealPower);
                }
                if (input.equals("i")) {
                    System.out.println("You saw that the " + boss.returnName() + " was trying to counter you, but you called its bluff!");
                    System.out.println("You take a good look at the " + boss.returnName() + ".");
                    System.out.println("Name: " + boss.returnName());
                    System.out.println("Strength " + boss.returnStat(1));
                    System.out.println("Defence: " + boss.returnStat(2));
                    System.out.println("Speed: " + boss.returnStat(0));
                }
            }
            if (bossInput.equals("s1") || bossInput.equals("s2") || bossInput.equals("s3")) {
                System.out.println("The " + boss.returnName() + " is about to do a special attack!");
                if (bossInput.equals("s1")) {
                    System.out.println("The " + boss.returnName() + " lowered some of your stats!");
                    z.changeStats((int) (-z.returnStat(0) * 0.10),(int) (-z.returnStat(1) * 0.10), (int) (-z.returnStat(2) * 0.10));
                }
                if (bossInput.equals("s2")) {
                    Monster monster = listOfSummons[Runner.generateRandomInteger(0,listOfSummons.length-1)];
                    System.out.println("The " + boss.returnName() + " summons one of its disciples to battle!");
                    System.out.println("You encounter a " + monster.returnName() + ".");
                    boolean died = BattleRoom.battle(z,monster);
                    if (!died) {
                        z.changeHealth((int) (z.maxHealth * 0.50));
                    }
                }
                if (bossInput.equals("s3")) {
                    boss.changeStats((int) (boss.returnStat(0) * 0.09),(int) (boss.returnStat(1) * 0.09),(int) (boss.returnStat(2) * 0.09));
                    System.out.println("The " + boss.returnName() + " increases some of its stats!");
                }
                if (!z.returnDeathStatus()) {
                    if (input.equals("a")) {

                    }
                    if (input.equals("d")) {

                    }
                    if (input.equals("i")) {

                    }
                }
            }

        }
        return true;
    }
}
