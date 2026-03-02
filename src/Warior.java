/**
 * Class, that extends Hero, characterized Warior
 */
public class Warior extends Hero {
    private int hp;
    private int atk;
    private int x, y;
    private int speed;

    /**
     * Constructor
     */
    public Warior() {
        super(0, 0, 120, 30, 20);
    }

    /**
     * Method, which increases warior's level
     */
    @Override
    public void lvlUp() {
        super.lvlUp();
    }
}
