package Monsters;

import Player.Tower;

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

    private int frame;

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

        this.frame = 3;
    }

    /**
     * Monster losses hp
     * @param howMuch - how much hp monster losses
     */
    public void lossHp(int howMuch) {
        this.hp -= howMuch;
        if (this.hp <= howMuch) {
            this.dead = true;
            this.frame = 2;
            this.deadAction();
        }
    }

    /**
     * Monster's attack
     * @param tower - object, attacked by enemy
     */
    public void attack(Tower tower) {
        tower.lossHp(this.atk);
        this.frame = 1;
    }

    /**
     * Monster's movement
     *
     * @param tower - object, to which monster goes
     */
    public void go(Tower tower) {
        while (this.x > tower.getX() + 5) {
            this.x -= this.speed;
            this.frame = 0;
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
        return this.maxHp;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getFrame() {
        return this.frame;
    }

    /**
     * Setters
     */
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }
}
