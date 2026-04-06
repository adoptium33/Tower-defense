package Monsters;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class, which extends Monsters.Enemy, characterizes a slime
 */
public class Slime extends Enemy {
    private BufferedImage[] move = new BufferedImage[2];
    private BufferedImage[] attack = new BufferedImage[2];
    private BufferedImage[] death = new BufferedImage[2];

    /**
     * Constructor
     */
    public Slime() {
        super(0, 0, 70, 25, 25, 5);

        //TODO create slime's images
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
     * Action, that slime does, when dies
     */
    @Override
    public ArrayList<Enemy> deadAction() {
        if (this.getMaxHp() >= 50) {
            ArrayList<Enemy> newSlimes = new ArrayList<>();

            Slime slime1 = new Slime();
            slime1.setMaxHp(this.getMaxHp() / 2);
            newSlimes.add(slime1);

            Slime slime2 = new Slime();
            slime2.setMaxHp(this.getMaxHp() / 2);
            newSlimes.add(slime2);

            return newSlimes;
        }
        return null;
    }
}
