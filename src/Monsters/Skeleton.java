package Monsters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class, that extends Monsters.Enemy, characterizes a skeleton
 */
public class Skeleton extends Enemy {
    private BufferedImage image;

    /**
     * Constructor
     */
    public Skeleton(int x, int y) {
        super(x, y, 150, 30, 15, 10);
        try {
            this.image = ImageIO.read(getClass().getResource("/skeleton/skeletonGo1.png"));
        } catch (IOException e) {
            this.image = null;
        }
    }

    /**
     * Method, which draws the skeleton
     * @param g2 - allows to draw images
     */
    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(this.image, this.getX(), this.getY(), 50, 50, null);
    }
}
