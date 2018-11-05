public class Monster extends Profile {


    private boolean dead = false;

    public Monster(String name, int maxHealth, int strength, int defence, int speed) {
        super(name, maxHealth, strength, defence, speed);
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
    public boolean returnDeathStatus() {
        return dead;
    }
}
