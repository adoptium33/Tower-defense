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
     * Knight's attack
     * @param enemy - object, attacked by hero
     */
    @Override
    public void attack(Enemy enemy) {
        super.attack(enemy);
    }

    /**
     * Method, which increases knight's level
     */
    @Override
    public void lvlUp() {
        super.lvlUp();
    }
}
