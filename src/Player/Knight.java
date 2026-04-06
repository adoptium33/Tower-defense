package Player;

import Monsters.Enemy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class, that extends Player.Hero, characterized knight
 */
public class Knight extends Hero {
    private BufferedImage[] moveRight = new BufferedImage[2];
    private BufferedImage[] moveLeft = new BufferedImage[2];
    private BufferedImage[] attack = new BufferedImage[2];

    /**
     * Constructor
     */
    public Knight() {
        super(0, 0, 40, 10);

        //TODO create knight's images
        try {
            this.moveRight[0] = ImageIO.read(new File("path to file"));
            this.moveRight[1] = ImageIO.read(new File("path to file"));

            this.moveLeft[0] = ImageIO.read(new File("path to file"));
            this.moveLeft[1] = ImageIO.read(new File("path to file"));

            this.attack[0] = ImageIO.read(new File("path to file"));
            this.attack[1] = ImageIO.read(new File("path to file"));
        } catch (IOException e) {
            this.moveRight[0] = null;
            this.moveRight[1] = null;

            this.moveLeft[0] = null;
            this.moveLeft[1] = null;

            this.attack[0] = null;
            this.attack[1] = null;
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
}
