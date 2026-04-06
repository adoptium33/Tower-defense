package Player;

import Monsters.Enemy;
import Monsters.Skeleton;

import javax.imageio.ImageIO;
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

    /**
     * Constructor
     */
    public Warrior() {
        super(0, 0, 30, 20);

        //TODO create warrior's images
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
