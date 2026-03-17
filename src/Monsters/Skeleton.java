package Monsters;

import Player.Tower;

/**
 * Class, that extends Monsters.Enemy, characterizes a skeleton
 */
public class Skeleton extends Enemy {

    /**
     * Constructor
     */
    public Skeleton() {
        super(0, 0, 100, 40, 15, 10);
    }

    /**
     * Monsters.Skeleton losses hp, when attacked
     * @param howMuch - how much hp monster losses
     */
    @Override
    public void lossHp(int howMuch) {
        super.lossHp(howMuch);
    }

    /**
     * Monsters.Skeleton's attack
     * @param tower - object, attacked by enemy
     */
    @Override
    public void attack(Tower tower) {
        super.attack(tower);
    }

    /**
     *  Skeletons's movement
     * @param tower - object, to which monster goes
     */
    @Override
    public void go(Tower tower) {
        super.go(tower);
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
}
