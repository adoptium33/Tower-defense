/**
 * Class, that extends Hero, characterized Warior
 */
public class Warior extends Hero {

    /**
     * Constructor
     */
    public Warior() {
        super(0, 0, 120, 30, 20);
    }

    /**
     * Warior's movement
     * @param enemy - object, to which hero goes
     */
    @Override
    public void go(Enemy enemy) {
        super.go(enemy);
    }

    /**
     * Method, which increases warior's level
     */
    @Override
    public void lvlUp() {
        super.lvlUp();
    }
}
