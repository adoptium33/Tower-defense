package Player;

import Monsters.Enemy;

/**
 * Class, that extends Player.Hero, characterized knight
 */
public class Knight extends Hero {

    /**
     * Constructor
     */
    public Knight() {
        super(0, 0, 40, 10);
    }

    /**
     * Player.Knight's attack
     * @param enemy - object, attacked by hero
     */
    @Override
    public void attack(Enemy enemy) {
        super.attack(enemy);
        if (this.isSuperhit()) {
            this.increaseStats();
        } else {
            this.decreaseStats();
        }
    }
}
