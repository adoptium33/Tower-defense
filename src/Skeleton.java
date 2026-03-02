import java.util.ArrayList;

/**
 * Class, that extends Enemy, characterizes a skeleton
 */
public class Skeleton extends Enemy {

    /**
     * Constructor
     */
    public Skeleton() {
        super(0, 0, 100, 40, 15, 10);
    }

    /**
     * Skeleton losses hp, when attacked
     * @param howMuch - how much hp monster losses
     */
    @Override
    public void lossHp(int howMuch) {
        super.lossHp(howMuch);
    }

    /**
     * Skeleton's attack
     * @param tower - object, that is damaged by skeleton
     */
    @Override
    public void attack(Tower tower) {

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
