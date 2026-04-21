package Player;

import Monsters.Enemy;
import Monsters.Skeleton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Class, that extends Player.Hero, characterized Player.Warrior
 */
public class Warrior extends Hero {
    private BufferedImage[] moveRight = new BufferedImage[2];
    private BufferedImage[] moveLeft = new BufferedImage[2];
    private BufferedImage[] attack = new BufferedImage[2];

    private int animationTick;
    private int currentFrame;

    /**
     * Constructor
     */
    public Warrior() {
        super(0, 0, 30, 20);

        this.animationTick = 0;
        this.currentFrame = 0;
        try {
            this.moveRight[0] = ImageIO.read(getClass().getResource("/warrior/warriorMoveRight1.png"));
            this.moveRight[1] = ImageIO.read(getClass().getResource("/warrior/warriorMoveRight2.png"));

            this.moveLeft[0] = ImageIO.read(getClass().getResource("/warrior/warriorMoveLeft1.png"));
            this.moveLeft[1] = ImageIO.read(getClass().getResource("/warrior/warriorMoveLeft2.png"));

            this.attack[0] = ImageIO.read(getClass().getResource("/warrior/warriorAttack1.png"));
            this.attack[1] = ImageIO.read(getClass().getResource("/warrior/warriorAttack2.png"));
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
        BufferedImage currentImage = null;
        if (this.animationTick >= 5) {
            this.currentFrame++;
            if (this.currentFrame == 2) {
                this.currentFrame = 0;
            }

            switch (this.getFrame()) {
                case 0:
                    currentImage = this.moveRight[currentFrame];
                    break;
                case 1:
                    currentImage = this.moveLeft[currentFrame];
                    break;
                case 2:
                    currentImage = this.attack[currentFrame];
                    break;
            }
        }
        g2.drawImage(currentImage, this.getX(), this.getY(), 100, 100, null);
    }
}
