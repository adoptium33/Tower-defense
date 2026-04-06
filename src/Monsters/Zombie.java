package Monsters;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class, which extends Monsters.Enemy, characterizes a zombie
 */
public class Zombie extends Enemy {
    private BufferedImage[] move = new BufferedImage[2];
    private BufferedImage[] attack = new BufferedImage[2];
    private BufferedImage[] death = new BufferedImage[2];

    /**
     * Constructor
     */
    public Zombie() {
        super(0, 0, 250, 20, 5, 15);

        //TODO create zombie's images
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
     * Action, that zombie does, when dies
     */
    @Override
    public ArrayList<Enemy> deadAction() {
        ArrayList<Enemy> newSkelEton = new ArrayList<>();
        newSkelEton.add(new Skeleton());
        return newSkelEton;
    }
}
