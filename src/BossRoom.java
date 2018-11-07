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
    private boolean visited = false;

    public boolean enterRoom(Profile z) {
        boolean concluded = false;
        map = newMapIcon;
        visited = true;
        z.setLocation(yLoc, xLoc);
        Boss boss = new Boss("Lord of the Bad People",250,75,60,100);
        while (!concluded && !z.returnDeathStatus()) {
            int damageToBoss, damageToPlayer;
            System.out.println("");
            System.out.println("=============================================================================");
            System.out.println("HP: " + z.health + " / " + z.maxHealth);
            System.out.println(boss.returnName() + "'s HP: " + boss.health + " / " + boss.maxHealth);
            System.out.println("What do you do? (A)ttack/(D)efend/(I)nspect/(R)un");
        }
        return true;
    }
}
