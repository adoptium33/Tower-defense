package Player;

import Monsters.Enemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class, that extends Player.Hero, characterized Player.Warrior
 */
public class Warrior extends Hero {
    private BufferedImage image;

    /**
     * Constructor
     */
    public Warrior(int x, int y) {
        super(x, y, 10, 15);
        try {
            this.image = ImageIO.read(getClass().getResource("/warrior/warriorMoveRight1.png"));
        } catch (IOException e) {
            this.image = null;
        }
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

    /**
     * Method, which draws the warrior
     * @param g2 - allows to draw images
     */
    public void draw(Graphics2D g2) {
        g2.drawImage(this.image, this.getX(), this.getY(), 50, 50, null);
    }
}
