/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class Profile {
    private String name;
    private int xLoc, yLoc, strength, defence, speed, health, maxHealth;
    private Item heldItem;
    boolean dead = false;


    // Constructing a profile. This class will be extended by a Monster class to generate a monster's
    // stats and stuff.
    public Profile(String name, int y, int x, int maxHealth) {
        this.name = name;
        this.xLoc = x;
        this.yLoc = y;
        this.speed = Runner.generateRandomInteger(10,70);
        this.strength = Runner.generateRandomInteger(15,50);
        this.defence = Runner.generateRandomInteger(15,50);
        this.maxHealth = maxHealth;
        health = maxHealth;
        heldItem = new Item("nothing",0,0,15);
    }

    public void giveItem(Item item) {
        heldItem = item;
    }

    public void changeHealth(int change) {
        health += change;
        if (health > maxHealth) {
            health = maxHealth;
        }
        if (health <= 0) {
            die();
        }
    }

    public void die() {
        dead = true;
    }

    public boolean returnDeathStatus() {
        return dead;
    }

    public void move(int y, int x) {
        xLoc += x;
        yLoc += y;
    }

    public void setLocation(int y, int x) {
        xLoc = x;
        yLoc = y;
    }

    public int[] returnLocation() {
        int[] z = {yLoc, xLoc};
        return z;
    }

    public int returnStat(int statId) {
        if (statId == 0) {
            return speed;
        }
        if (statId == 1) {
            return strength;
        }
        if (statId == 2) {
            return defence;
        }
        else {
            return 100000;
            // Why 100,000? If I get a horrifyingly high number in the output, I know exactly where to look...
        }
    }

}
