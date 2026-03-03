public abstract class Hero {
    private int x, y, hp, maxHp, atk, speed;

    /**
     * Constructor
     * @param x     - position x
     * @param y     - position y
     * @param hp    - hero's hp
     * @param atk   - hero's atk
     * @param speed - hero's speed
     */
    public Hero(int x, int y, int hp, int atk, int speed) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.maxHp = hp;
        this.atk = atk;
        this.speed = speed;
    }

    /**
     * Hero's movement
     * @param enemy - object, to which hero goes
     */
    public void go(Enemy enemy) {
        while (this.x != enemy.getX() + 5 ) {
            if (this.x < enemy.getX() + 5) {
                this.x += speed;
            } else if (this.x > enemy.getX() + 5) {
                this.x -= speed;
            } else {
                //TODO attack method
            }
        }
    }

    /**
     * Method, which increases a hero
     */
    public void lvlUp() {
        this.hp += 10;
        this.maxHp += 10;
        this.atk += 5;
        this.speed += 2;
    }
}
