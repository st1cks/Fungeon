import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

    public boolean enterRoom(Profile z) {
        boolean concluded = false;
        map = newMapIcon;
        visited = true;
        z.setLocation(yLoc, xLoc);
        Boss boss = new Boss("Lord of the Bad People",250,60,60,100);
        boss.scaleStats(z.getMonstersKilled());
        z.changeStats((int) (z.returnStat(0) * 0.50), (int) (z.returnStat(1) * 0.50), (int) (z.returnStat(2) * 0.50));
        System.out.println("The door shuts behind you, and you are now locked in a battle with " + boss.returnName() + ".");
        while (!boss.returnDeathStatus() && !z.returnDeathStatus()) {
            int damageToBoss, damageToPlayer;
            System.out.println("=============================================================================");
            System.out.println("HP: " + z.health + " / " + z.maxHealth);
            System.out.println(boss.returnName() + "'s HP: " + boss.health + " / " + boss.maxHealth);
            System.out.println("What do you do? (A)ttack/(D)efend/(I)nspect/S(T)ats");

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
            if (input.equals("t") || input.equals("r")) {
                if (input.equals("t")) {
                    System.out.println("Name: " + z.returnName());
                    System.out.println("Health: " + z.health + " / " + z.maxHealth);
                    System.out.println("Strength: " + z.returnStat(1) + " (" + z.returnItem().strengthBonus + ")");
                    System.out.println("Defence: " + z.returnStat(2) + " (" + z.returnItem().defenceBonus + ")");
                    System.out.println("Speed: " + z.returnStat(0) + " (" + z.returnItem().speedBonus + ")");
                    System.out.println("Item: " + z.returnItem().name);
                }
                else {
                    z.changeHealth(-1000000);
                    System.out.println("                             ,..oooooooooob..\n" +
                            "                       ,.dodOOOO\"\"\"\"\"\":\"ooPO88bo..\n" +
                            "                     .o8O\"\"\" '            \"'\"\"\"PO8b.\n" +
                            "                 .dd8P'\"                       ''::Y8o.\n" +
                            "               ,d8Po'                             \"':7Ob;\n" +
                            "              d8P::'                                 ';:8b.\n" +
                            "            ;d8''\"                                     ';Y8;\n" +
                            "          ,d8O:'                                        ';:8b.\n" +
                            "         ,88o:'                                           ';Yb.\n" +
                            "        ,8P::'                                           . ';Yb\n" +
                            "       ,8o;:'                                          ,;'  ':8b\n" +
                            "      ,8:::'                                           ;:    :;8b\n" +
                            "     d8o;::                                            o:     ::8,\n" +
                            "    ,8':::                                            :::     :;Y8\n" +
                            "    8'oo:'                                            :::     :::8:\n" +
                            "   dP;:YO                                             ':::;.;;:::Y8.\n" +
                            "  ,8:::;Yb                                            :b::::::::::8b\n" +
                            "  dO;::::8b                                           'Yb::::::::::8.\n" +
                            " ,8;:::::O8,                                           'Y88::::::::8:\n" +
                            " 8P;::::::88                                             `8O::::::::O\n" +
                            " d::::::::88:                                             O8;:::::::8\n" +
                            " 8:::::::888:                                             88b:::::::O:\n" +
                            ",8::::::::88:                                            :888Oooo::;Y:\n" +
                            "dO:::::::bO8:             ..:.::::::::::...:             :888888P;::db\n" +
                            "OP:::::::O88:         ..o8888:::::::::::::)8888bo..       O8888O:::::8\n" +
                            "O;::::::::88'    ..od888888888::::\"\"\"\":::88888888888oo;   `8888;:::::8\n" +
                            "O:::ob:::;8:  ,d88888888888888::       ':88888888888888b;  '\"88;:::::8\n" +
                            "OO::;Yo::OP' d888888888888888O:'      ,.;8888888888888888b  ,88::::::8\n" +
                            "YO:::;Y::Ob ,8888888888888888;::       :;88888888888888888  :88::::::8\n" +
                            " 8;::::b;8' :8888888888888888o::        ':8888888888888888  :888d::)88\n" +
                            " Y:::::88P   888888888888888888'         'O888888888888888  :88888888P\n" +
                            " `b:::;8O    d888888888888888P'          ,8888888888888888  '88888888:\n" +
                            "  Y::::8:   ,88888888888888P:      ..    '8888888888888888   Y8888888:\n" +
                            "  8O::;8'   :88888888888888:      d88,   ':Y88888888888888   '8888888:\n" +
                            "  'YbooO    :8888888888P:8P:     :8888:    '':Y8888888888P    \"Y888YP\n" +
                            "   '888:     8888888P:;'8O:'     :8P88b       '\"O888888P\"       ;:;o'\n" +
                            "    `88:     \"oOOo:.::)O:;:      :8:888.        :8b'            :::'\n" +
                            "     88:      '\"\"\"\" ,do;:'      ,88bO88b     ,.o::PO:;.;.      :::'\n" +
                            "     88';           :' `Yb      d88O`888b    O8\"::::o::::::::::o:;\n" +
                            "     8O::b         ;:   ''     d88Po O888    :8;:\"\"\" '\";88::::o:::\n" +
                            "     YO:;Yb    :o.;::          O8P.: O888     'Y::    :YO8b:::::O'\n" +
                            "      Y:::8b  o;O:::;.         OO;:: OO;'       ''\"  .;bO88\"d:od'\n" +
                            "      `b::;8: :8bo::::;.       OO::: OK:          ,;:8888P',8OP\"\n" +
                            "       Yb:;OO  O888b::::;.     'O:O\",;\"'          ;o8888P  :O\"\n" +
                            "       '`Y888. :88888::::::     ':' db           ;o8888P   8P\n" +
                            "          '`8;  O8888::::::        '8'          :o8888P   :8'\n" +
                            "            OO: :8888::::::         Y:         ,::;888'   :8\n" +
                            "            `8,  o888\"::::'          '         ;:::88:    OP\n" +
                            "            ,8:   O888O8POYOOO\"OPOOPYO8OO8OO888888888'    O:\n" +
                            "            88:   '888o::o':Y: d  O  'Y:'8: O\"Y:`K:8o;    8'\n" +
                            "           88O;    ;88o;:::: : :  :   '  `:   '  ,:8 :   :8\n" +
                            "           O8O:.  ,:OP\"8bd;':: d...      ,.  .db.'\"8 ::  :O\n" +
                            "          ,88O::. ;:O: O\"'\"YP\"YPYP'YO\"\"\"`8K`O\"O `b:O.:;  :O\n" +
                            "          888o:::.:;Ob : :::: :::: :P ,  OO : :  O;:::: ;:O\n" +
                            "          888O::::::::`dbd::b.d::: :: db ::,d.8o;O;::::::dP\n" +
                            "           888::::::::;:\"\"\"\"\"Y8888od8d88o8P\"\"'\"  ':::::'d'\n" +
                            "           \"Y88Odo:\"::::         `\"\"\"\"'           ':::)P'\n" +
                            "             \"\"88888O:::                          ;::dP\n" +
                            "                '\"\"88O:::                   oo;  ;O88'\n" +
                            "                   `Y8O::.  ,.      .      '8b::O88'\n" +
                            "                     Y8b::. ,)O   ,;'        ::O88'\n" +
                            "                      '88d:..:   ,d:        ;'d88'\n" +
                            "                       'Y88d::;.;:8b,   ,..:O88P'\n" +
                            "                         \"\"88oodO888O::::bd88P'\n" +
                            "                           '`8888888888888P\"'\n" +
                            "                                 \"\"\"\"\"\"\"\"'\n" +
                            "\n");
                    // Courtesy of https://asciiart.website/
                    // This ASCII pic can be found at https://asciiart.website/index.php?art=people/skeletons
                    try {
                        Thread.sleep(3000);
                    }
                    catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    for (int i = 0; i < 500; i ++) {
                        System.out.println("WHO ARE YOU RUNNING FROM?");
                    }
                    try {
                        Thread.sleep(5000);
                    }
                    catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            else {
                if (bossInput.equals("a")) {
                    if (input.equals("a")) {
                        System.out.println("You both charge for each other!");
                        damageToBoss = Runner.generateRandomInteger((int) (8.0 * playerStrength), (int) (15.0 * playerStrength));
                        damageToPlayer = Runner.generateRandomInteger((int) (8.0 * bossStrength), (int) (15.0 * bossStrength));
                        boss.changeHealth(-damageToBoss);
                        System.out.println("You attack the " + boss.returnName() + " for " + damageToBoss + " damage!");
                        if (!boss.returnDeathStatus()) {
                            z.changeHealth(-damageToPlayer);
                            System.out.println("The " + boss.returnName() + " deals " + damageToPlayer + " damage to you.");
                        }
                    }
                    if (input.equals("d")) {
                        System.out.println("You took a defensive stance, but you're ready to absorb the blow of the " + boss.returnName() + "!");
                        damageToPlayer = Runner.generateRandomInteger((int) (3.0 * bossStrength), (int) (7.0 * bossStrength));
                        z.changeHealth(-damageToPlayer);
                        System.out.println("You suffered " + damageToPlayer + " damage.");
                    }
                    if (input.equals("i")) {
                        System.out.println("You observe the " + boss.returnName() + " as it attacks you!");
                        damageToPlayer = Runner.generateRandomInteger((int) (4.0 * bossStrength), (int) (8.0 * bossStrength));
                        z.changeHealth(-damageToPlayer);
                        System.out.println("You suffered " + damageToPlayer + " damage, but you were somewhat ready for the attack.");
                        System.out.println("Name: " + boss.returnName());
                        System.out.println("Strength " + boss.returnStat(1));
                        System.out.println("Defence: " + boss.returnStat(2));
                        System.out.println("Speed: " + boss.returnStat(0));
                    }
                }
                if (bossInput.equals("d")) {
                    if (input.equals("a")) {
                        System.out.println("The " + boss.returnName() + " took a defensive stance, reflecting your attacks!");
                        System.out.println("You fall right for the counter!");
                        damageToBoss = Runner.generateRandomInteger((int) (6.0 * playerStrength), (int) (10.0 * playerStrength));
                        damageToPlayer = (int) (damageToBoss * 0.25);
                        System.out.println("You attacked the " + boss.returnName() + " and dealt " + damageToBoss + " damage!");
                        System.out.println("You suffered " + damageToPlayer + " recoil damage.");
                        boss.changeHealth(-damageToBoss);
                        z.changeHealth(-damageToPlayer);
                    }
                    if (input.equals("d")) {
                        System.out.println("The " + boss.returnName() + " took a defensive stance, reflecting your attacks!");
                        System.out.println("The " + boss.returnName() + " expected an attack, but you called its bluff!");
                        z.changeHealth(playerHealPower);
                    }
                    if (input.equals("i")) {
                        System.out.println("The " + boss.returnName() + " took a defensive stance, reflecting your attacks!");
                        System.out.println("You saw that the " + boss.returnName() + " was trying to counter you, but you called its bluff!");
                        System.out.println("You take a good look at the " + boss.returnName() + ".");
                        System.out.println("Name: " + boss.returnName());
                        System.out.println("Strength " + boss.returnStat(1));
                        System.out.println("Defence: " + boss.returnStat(2));
                        System.out.println("Speed: " + boss.returnStat(0));
                    }
                }
                if (bossInput.equals("s1") || bossInput.equals("s2") || bossInput.equals("s3")) {
                    if (bossInput.equals("s1")) {
                        System.out.println("The " + boss.returnName() + " is about to do a special attack!");
                        System.out.println("The " + boss.returnName() + " lowered some of your stats!");
                        z.changeStats((int) (-z.returnStat(0) * 0.10), (int) (-z.returnStat(1) * 0.10), (int) (-z.returnStat(2) * 0.10));
                    }
                    if (bossInput.equals("s2")) {
                        Monster[] listOfSummons = {
                                new Monster("Bad Guy 1",30,50,50,100),
                                new Monster("Bad Guy 2",70,25,25,100),
                                new Monster("Bad Guy 3", 20,90,25,100)
                        };
                        System.out.println("The " + boss.returnName() + " is about to do a special attack!");
                        Monster monster = listOfSummons[Runner.generateRandomInteger(0, listOfSummons.length - 1)];
                        System.out.println("The " + boss.returnName() + " summons one of its disciples to battle!");
                        System.out.println("You encounter a " + monster.returnName() + ".");
                        boolean died = BattleRoom.battle(z, monster);
                        System.out.println("=============================================================================");
                        if (!died) {
                            z.changeHealth((int) (monster.maxHealth * 0.25));
                            System.out.println("You absorb the " + monster.returnName() + "'s powers and gain " + (int) (monster.maxHealth * 0.25) + " health.");
                        }
                    }
                    if (bossInput.equals("s3")) {
                        System.out.println("The " + boss.returnName() + " is about to do a special attack!");
                        boss.changeStats((int) (boss.returnStat(0) * 0.09), (int) (boss.returnStat(1) * 0.09), (int) (boss.returnStat(2) * 0.09));
                        System.out.println("The " + boss.returnName() + " increases some of its stats!");
                    }
                    if (!z.returnDeathStatus()) {
                        if (input.equals("a")) {
                            damageToBoss = Runner.generateRandomInteger((int) (10.0 * playerStrength), (int) (20.0 * playerStrength));
                            boss.changeHealth(-damageToBoss);
                            System.out.println("You take your opportunity to strike, dealing " + damageToBoss + " damage!");
                        }
                        if (input.equals("d")) {
                            System.out.println("You gain residual health by defending against the " + boss.returnName());
                            z.changeHealth(playerHealPower);
                        }
                        if (input.equals("i")) {
                            System.out.println("You take a good look at the " + boss.returnName() + ".");
                            System.out.println("Name: " + boss.returnName());
                            System.out.println("Strength " + boss.returnStat(1));
                            System.out.println("Defence: " + boss.returnStat(2));
                            System.out.println("Speed: " + boss.returnStat(0));
                        }
                    }
                }
            }

        }
        return true;
    }
    public void leaveRoom() {

    }

    public String[] returnMapPortion() {
        return map;
    }

    public boolean bossRoom() {
        return true;
    }
    public boolean isAnActualRoom() {
        return true;
    }
}
