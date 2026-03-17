package Player;

import Monsters.Enemy;

/**
 * Class, that extends Player.Hero, characterized Player.Warrior
 */
public class Warrior extends Hero {

    /**
     * Constructor
     */
    public Warrior() {
        super(0, 0, 120, 30, 20);
    }

    /**
     * Player.Warrior's movement
     * @param enemy - object, to which hero goes
     */
    @Override
    public void go(Enemy enemy) {
        super.go(enemy);
    }

    /**
     * Player.Warrior's attack
     * @param enemy - object, attacked by hero
     */
    @Override
    public void attack(Enemy enemy) {
        super.attack(enemy);
    }

    /**
     * Method, which increases warrior's level
     */
    @Override
    public void lvlUp() {
        super.lvlUp();
    }
}
