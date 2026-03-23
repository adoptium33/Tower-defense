package Player;

import Monsters.Enemy;

public abstract class Hero {
    private int x;
    private int y;
    private int atk;
    private int speed;
    private boolean superhit;

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
    }

    /**
     * Player.Hero's movement
     * @param enemy - object, to which hero goes
     */
    public void go(Enemy enemy) {
        while (this.x != enemy.getX() + 5 ) {
            if (this.x < enemy.getX() + 5) {
                this.x += this.speed;
            } else if (this.x > enemy.getX() + 5) {
                this.x -= this.speed;
            }
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
     * Method, which increases a hero
     */
    public void lvlUp() {
        this.atk += 5;
        this.speed += 2;
    }

    /**
     * Method which allows user to start superHit of hero for a 60 seconds
     * @throws InterruptedException
     */
    public void superHit() throws InterruptedException {
        Thread timer = new Thread();
        int seconds = 60;
        while (seconds > 0) {
            timer.sleep(1000);
            seconds--;
            this.superhit = true;
        }
        this.superhit = false;
    }

    /**
     * Special methods, which helps with knight's superhit
     */
    public void increaseStats () {
        this.atk += 15;
        this.speed += 10;
    }
    public void decreaseStats () {
        this.atk -= 15;
        this.speed -= 10;
    }

    /**
     * Getters
     */
    public boolean isSuperhit() {
        return superhit;
    }
}
