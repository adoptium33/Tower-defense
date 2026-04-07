package Monsters;

import javax.imageio.ImageIO;
import java.awt.*;
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

    private int animationTick;
    private int currentFrame;

    /**
     * Constructor
     */
    public Skeleton() {
        super(0, 0, 100, 40, 15, 10);

        this.animationTick = 0;
        this.currentFrame = 0;
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

    /**
     * Method, which draws the skeleton
     * @param g2 - allows to draw images
     */
    @Override
    public void draw(Graphics2D g2) {
        BufferedImage currentImage = null;
        if (this.animationTick >= 5) {
            this.currentFrame++;
            if (this.currentFrame == 2) {
                this.currentFrame = 0;
            }

            switch (this.getFrame()) {
                case 0:
                    currentImage = this.move[currentFrame];
                    break;
                case 1:
                    currentImage = this.attack[currentFrame];
                    break;
                case 2:
                    currentImage = this.death[currentFrame];
                    break;
            }
        }
        g2.drawImage(currentImage, this.getX(), this.getY(), 100, 100, null);
    }
}
