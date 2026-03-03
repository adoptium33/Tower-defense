/**
 * Class, that extends Hero, characterized knight
 */
public class Knight extends Hero {

    /**
     * Constructor
     */
    public Knight() {
        super(0, 0, 200, 40, 10);
    }

    /**
     * Knight's movement
     * @param enemy - object, to which hero goes
     */
    @Override
    public void go(Enemy enemy) {
        super.go(enemy);
    }

    /**
     * Method, which increases knight's level
     */
    @Override
    public void lvlUp() {
        super.lvlUp();
    }
}
