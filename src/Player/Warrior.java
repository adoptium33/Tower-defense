package Player;

import Monsters.Enemy;
import Monsters.Skeleton;

/**
 * Class, that extends Player.Hero, characterized Player.Warrior
 */
public class Warrior extends Hero {

    /**
     * Constructor
     */
    public Warrior() {
        super(0, 0, 30, 20);
    }

    /**
     * Player.Warrior's attack. If superhit is active, when warrior kills enemy, increases his lvl
     * @param enemy - object, attacked by hero
     */
    @Override
    public void attack(Enemy enemy) {
        super.attack(enemy);
        if (enemy.isDead() && this.isSuperhit()) {
            this.lvlUp();
        }
    }
}
