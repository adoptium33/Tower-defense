import java.util.ArrayList;

/**
 * Class, which extends Enemy, characterizes a slime
 */
public class Slime extends Enemy {

    /**
     * Constructor
     */
    public Slime() {
        super(0, 0, 70, 25, 25, 5);
    }

    /**
     * Slime losses hp
     * @param howMuch - how much hp monster losses
     */
    @Override
    public void lossHp(int howMuch) {
        super.lossHp(howMuch);
    }

    /**
     * Slime's attack
     * @param tower - object, attacked by enemy
     */
    @Override
    public void attack(Tower tower) {
        super.attack(tower);
    }

    /**
     * Slime's movement
     * @param tower - object, to which monster goes
     */
    @Override
    public void go(Tower tower) {
        super.go(tower);
    }

    /**
     * Action, that slime does, when dies
     */
    @Override
    public ArrayList<Enemy> deadAction() {
        if (this.getMaxHp() >= 50) {
            ArrayList<Enemy> newSlimes = new ArrayList<>();

            Slime slime1 = new Slime();
            slime1.setMaxHp(this.getMaxHp() / 2);
            newSlimes.add(slime1);

            Slime slime2 = new Slime();
            slime2.setMaxHp(this.getMaxHp() / 2);
            newSlimes.add(slime2);

            return newSlimes;
        }
        return null;
    }

    /**
     * Getters
     * @return
     */
    @Override
    public boolean isDead() {
        return super.isDead();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public int getMaxHp() {
        return super.getMaxHp();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    /**
     * Setters
     * @param maxHp - new maxHp
     */
    @Override
    public void setMaxHp(int maxHp) {
        super.setMaxHp(maxHp);
    }
}
