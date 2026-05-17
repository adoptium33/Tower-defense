package monsters;

import player.Tower;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Abstract class, which characterizes an enemy
 */
public abstract class Enemy {
    private int x;
    private int y;
    private int hp;
    private int maxHp;
    private int atk;
    private int speed;
    private int price;
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
        if (this.hp <= howMuch) {
            this.dead = true;
            this.deadAction();
        }
    }

    /**
     * Monster's attack
     * @param tower - object, attacked by enemy
     */
    public void attack(Tower tower) {
        tower.lossHp(this.atk);
    }

    /**
     * Monster's movement
     *
     * @param tower - object, to which monster goes
     */
    public void go(Tower tower) {
        if (this.x > tower.getX() + 500) {
            this.x -= this.speed;
        }
    }

    /**
     * Monster moves slower if heroes near him
     * @param tower - object, to which monster goes
     */
    public void goSlower(Tower tower) {
        if (this.x > tower.getX() + 500) {
            this.x -= (this.speed - 7);
        }
    }

    /**
     * Method, which starts, when monster is dead
     */
    public ArrayList<Enemy> deadAction() {
        return new ArrayList<>();
    }

    /**
     * Method, that draws enemy to screen
     * @param g2 - allows to draw images
     */
    public void draw(Graphics2D g2) {

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
        return this.maxHp;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Setters
     */
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
        this.hp = maxHp;
    }
}
