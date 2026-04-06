package Monsters;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class, that extends Monsters.Enemy, characterizes a skeleton
 */
public class Skeleton extends Enemy {
    private BufferedImage[] move = new BufferedImage[2];
    private BufferedImage[] attack = new BufferedImage[2];
    private BufferedImage[] death = new BufferedImage[2];

    /**
     * Constructor
     */
    public Skeleton() {
        super(0, 0, 100, 40, 15, 10);

        //TODO create skeleton's images
        try {
            this.move[0] = ImageIO.read(new File("path to file"));
            this.move[1] = ImageIO.read(new File("path to file"));

            this.attack[0] = ImageIO.read(new File("path to file"));
            this.attack[1] = ImageIO.read(new File("path to file"));

            this.death[0] = ImageIO.read(new File("path to file"));
            this.death[1] = ImageIO.read(new File("path to file"));
        } catch (IOException e) {
            this.move[0] = null;
            this.move[1] = null;

            this.attack[0] = null;
            this.attack[1] = null;

            this.death[0] = null;
            this.death[1] = null;
        }
    }
}
