package Monsters;
import java.util.ArrayList;

/**
 * Class, which extends Monsters.Enemy, characterizes a zombie
 */
public class Zombie extends Enemy {

    /**
     * Constructor
     */
    public Zombie() {
        super(0, 0, 250, 20, 5, 15);
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
}
