package Player;

import Monsters.Enemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class, that extends Player.Hero, characterized knight
 */
public class Knight extends Hero {
    private BufferedImage image;

    /**
     * Constructor
     */
    public Knight(int x, int y) {
        super(x, y, 40, 10);
        try {
            this.image = ImageIO.read(getClass().getResource("/knight/knightMoveRight1.png"));
        } catch (IOException e) {
            this.image = null;
        }
    }

    /**
     * Player.Knight's attack. Superhit increases stats of Knight for 60 seconds
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

    /**
     * Method, which draws the knight
     * @param g2 - allows to draw images
     */
    public void draw(Graphics2D g2) {
        g2.drawImage(this.image, this.getX(), this.getY(), 50, 50, null);
    }
}
