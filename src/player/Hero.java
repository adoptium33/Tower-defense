package player;

import monsters.Enemy;

import javax.swing.Timer;

/**
 * Abstract class, that characterizes heroes
 */
public abstract class Hero {
    private int x;
    private int y;
    private int atk;
    private int speed;
    private boolean superhit;
    private boolean endOfSuperHit;

    /**
     * Constructor
     * @param x     - position x
     * @param y     - position y
     * @param atk   - hero's atk
     * @param speed - hero's speed
     */
    public Hero(int x, int y, int atk, int speed) {
        this.x = x;
        this.y = y;
        this.atk = atk;
        this.speed = speed;
        this.superhit = false;
        this.endOfSuperHit = false;
    }

    /**
     * Player.Hero's movement
     */
    public void go() {
        this.x += this.speed;
        if (this.x >= 1400) {
            this.x = 500;
        }
    }

    /**
     * Player.Hero's attack
     * @param enemy - object, attacked by hero
     */
    public void attack(Enemy enemy) {
        enemy.lossHp(this.atk);
    }

    /**
     * Method, which increases a hero's level
     */
    public void lvlUp() {
        this.atk += 1;
        this.speed += 1;
    }

    /**
     * Method which allows user to start superHit of hero for 60 seconds
     */
    public void superHit() {
        this.superhit = true;
        Timer t = new Timer(60000, e -> {
            this.superhit = false;
            this.endOfSuperHit = true;
        });
        t.setRepeats(false);
        t.start();
    }

    /**
     * Special methods, which helps with knight's superhit
     */
    public void increaseStats () {
        this.atk += 15;
        this.speed += 5;
    }
    public void decreaseStats () {
        this.atk -= 15;
        this.speed -= 5;
    }

    /**
     * Getters
     */
    public boolean isSuperhit() {
        return this.superhit;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    protected boolean isEndOfSuperHit() {
        return this.endOfSuperHit;
    }
    /**
     * Setters
     */
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    protected void setEndOfSuperHit() {
        this.endOfSuperHit = false;
    }
}
