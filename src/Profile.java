/**
 * JESSE HAN
 * AP JAVA PERIOD 4, 5
 * MR FOLWELL'S CLASS
 * I MADE THIS
 * IT TOOK A WHILE
 **/

public class Profile {
    String name;
    int xLoc, yLoc, strength, defence, speed, health, maxHealth; int monstersKilled;
    Item heldItem;
    boolean dead = false;


    // Constructing a profile. This class will be extended by a Monster class to generate a monster's
    // stats and stuff.
    public Profile(String name, int y, int x, int maxHealth) {
        this.name = name;
        this.xLoc = x;
        this.yLoc = y;
        this.speed = Runner.generateRandomInteger(25,40);
        this.strength = Runner.generateRandomInteger(25,35);
        this.defence = Runner.generateRandomInteger(25,35);
        this.maxHealth = maxHealth;
        health = maxHealth;
        this.monstersKilled = 0;
        heldItem = new Item("nothing",0,0,15);
    }

    public Profile(String name, int maxHealth, int strength, int defence, int speed) {
        this.name = name;
        this.maxHealth = maxHealth;
        health = maxHealth;
        this.strength = strength;
        this.defence = defence;
        this.speed = speed;
    }

    public int getMonstersKilled() {
        return monstersKilled;
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

    public Item returnItem() {
        return heldItem;
    }

    public String returnName() {
        return name;
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

    public int returnCalculatedStats(int statId) {
        if (statId == 0) {
            return speed + returnItem().speedBonus;
        }
        if (statId == 1) {
            return strength + returnItem().strengthBonus;
        }
        if (statId == 2) {
            return defence + returnItem().defenceBonus;
        }
        else {
            System.out.println("Uh-oh! This is an error!");
            return 10000000;
        }
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
            System.out.println("Uh-oh! This is an error!");
            return 100000;
            // Why 100,000? If I get a horrifyingly high number in the output, I know exactly where to look...
        }
    }

    public void changeStats(int spe, int str, int def) {
        speed += spe;
        strength += str;
        defence += def;
    }

}
