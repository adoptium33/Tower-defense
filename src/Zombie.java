import java.util.ArrayList;

/**
 * Class, which extends Enemy, characterizes a zombie
 */
public class Zombie extends Enemy {

    /**
     * Constructor
     */
    public Zombie() {
        super(0, 0, 250, 20, 5, 15);
    }

    /**
     * Zombie losses hp
     * @param howMuch - how much hp monster losses
     */
    @Override
    public void lossHp(int howMuch) {
        super.lossHp(howMuch);
    }

    /**
     * Zombie's attack
     * @param tower - object, that is damaged by zombie
     */
    @Override
    public void attack(Tower tower) {

    }

    /**
     * Action, that zombie does, when dies
     */
    @Override
    public ArrayList<Enemy> deadAction() {
        ArrayList<Enemy> newSkelEton = new ArrayList<>();
        newSkelEton.add(new Skeleton());
        return newSkelEton;
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
