package Player;

import Monsters.Enemy;

public abstract class Hero {
    private int x;
    private int y;
    private int atk;
    private int speed;
    private boolean superhit;

    private int frame;

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

        this.frame = 3;
    }

    /**
     * Player.Hero's movement
     * @param enemy - object, to which hero goes
     */
    public void go(Enemy enemy) {
        while (this.x != enemy.getX() + 5 || this.x != enemy.getX() - 5) {
            if (this.x < enemy.getX() - 5) {
                this.x += this.speed;

                this.frame = 0;
            } else if (this.x > enemy.getX() + 5) {
                this.x -= this.speed;

                this.frame = 1;
            }
        }
        this.attack(enemy);
    }

    /**
     * Player.Hero's attack
     * @param enemy - object, attacked by hero
     */
    public void attack(Enemy enemy) {
        this.frame = 2;
        while (!enemy.isDead()) {
            enemy.lossHp(this.atk);
        }
    }

    /**
     * Method, which increases a hero
     */
    public void lvlUp() {
        this.atk += 5;
        this.speed += 2;
    }

    /**
     * Method which allows user to start superHit of hero for a 60 seconds,
     * method was fixed by Gemini AI, cause my code interrupts the main thread
     */
    public void superHit() {
        Thread timer = new Thread(() -> {
            try {
                this.superhit = true;

                for (int i = 60; i > 0; i--) {
                    Thread.sleep(1000);
                }

                this.superhit = false;
            } catch (InterruptedException e) {
                this.superhit = false;
            }
        });

        timer.start();
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

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getFrame() {
        return this.frame;
    }
}
