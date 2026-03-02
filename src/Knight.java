/**
 * Class, that extends Hero, characterized knight
 */
public class Knight extends Hero {
    private int hp;
    private int atk;
    private int x, y;
    private int speed;

    /**
     * Constructor
     */
    public Knight() {
        super(0, 0, 200, 40, 10);
    }

    /**
     * Method, which increases knight's level
     */
    @Override
    public void lvlUp() {
        super.lvlUp();
    }
}
