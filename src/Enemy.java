import java.util.ArrayList;

/**
 * Abstract class, which characterizes an enemy
 */
public abstract class Enemy {
    private int x, y, hp, maxHp, atk, speed, price;
    private boolean dead;

    /**
     * Constructor
     * @param x     - position x
     * @param y     - position y
     * @param hp    - hp of an enemy
     * @param atk   - atk of an enemy
     * @param speed - speed of an enemy
     * @param price - amount of coins, which you get, when kill an enemy
     */
    public Enemy(int x, int y, int hp, int atk, int speed, int price) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.maxHp = hp;
        this.atk = atk;
        this.speed = speed;
        this.price = price;
        this.dead = false;
    }

    /**
     * Monster losses hp
     * @param howMuch - how much hp monster losses
     */
    public void lossHp(int howMuch) {
        this.hp -= howMuch;
    }

    /**
     * Method for monster's attack
     */
    public void attack(Tower tower ) {

    }

    /**
     * Monster's movement
     *
     * @param tower - object, to which monster goes
     */
    public void go(Tower tower) {
        while (this.x > tower.getX() + 5) {
            this.x -= speed;
        }
    }

    /**
     * Method, which starts, when monster is dead
     */
    public ArrayList<Enemy> deadAction() {
        return null;
    }

    /**
     * Getters
     * @return
     */
    public boolean isDead() {
        return this.dead;
    }

    public int getPrice() {
        return this.price;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getX() {
        return x;
    }

    /**
     * Setters
     */
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
}
