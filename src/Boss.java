public class Boss extends Profile {

    private boolean dead = false;
    private String decision;

    public Boss(String name, int maxHealth, int strength, int defence, int speed) {
        super(name, maxHealth, strength, defence, speed);
    }

    public void changeHealth(int change) {
        health += change;
        if (change > 0) {
            if (health > maxHealth) {
                System.out.println("The " + name + " recovers " + (change-(health - maxHealth)) + " health.");
                health = maxHealth;
            }
            else {
                System.out.println("The " + name + " recovers " + change + " health.");
            }
        }
        if (health <= 0) {
            die();
        }
    }

    public void die() {
        dead = true;
    }

    public void scaleStats(int monstersKilled) {
        this.maxHealth = (int) (maxHealth * (1 + (monstersKilled * 0.10)));
        health = maxHealth;
        this.strength = (int) (strength * (1 + (monstersKilled * 0.15)));
        this.defence = (int) (defence * (1 + (monstersKilled * 0.15)));
        this.speed = (int) (speed * (1 + (monstersKilled * 0.10)));
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

    public String makeChoice() {
        int random = Runner.generateRandomInteger(0,7);
        int randomSpecial = Runner.generateRandomInteger(0,2);
        if (random < 3) {
            return "a";
        }
        else if (random < 6) {
            return "d";
        }
        else {
            if (randomSpecial == 0) {
                return "s1"; // Special 1: Permanently lower stats slightly
            }
            if (randomSpecial == 1) {
                return "s2"; // Special 2: Summon an enemy.
            }
            else {
                return "s3"; // Special 3: Buff own stats.
            }
        }
    }

    public boolean returnDeathStatus() {
        return dead;
    }
}
