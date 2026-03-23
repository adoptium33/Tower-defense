package Monsters;
import java.util.ArrayList;

/**
 * Class, which extends Monsters.Enemy, characterizes a slime
 */
public class Slime extends Enemy {

    /**
     * Constructor
     */
    public Slime() {
        super(0, 0, 70, 25, 25, 5);
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
}
