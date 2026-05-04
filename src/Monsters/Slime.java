package Monsters;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class, which extends Monsters.Enemy, characterizes a slime
 */
public class Slime extends Enemy {
    private BufferedImage image;

    /**
     * Constructor
     */
    public Slime(int x, int y) {
        super(x, y, 70, 15, 25, 5);
        try {
            this.image = ImageIO.read(getClass().getResource("/slime/slimeGo1.png"));
        } catch (IOException e) {
            this.image = null;
        }
    }

    /**
     * Action, that slime does, when dies
     */
    @Override
    public ArrayList<Enemy> deadAction() {
        if (this.getMaxHp() == 70) {
            ArrayList<Enemy> newSlimes = new ArrayList<>();

            Slime slime1 = new Slime(this.getX(), this.getY());
            slime1.setMaxHp(this.getMaxHp() / 2);
            newSlimes.add(slime1);

            Slime slime2 = new Slime(this.getX() - 10, this.getY());
            slime2.setMaxHp(this.getMaxHp() / 2);
            newSlimes.add(slime2);

            return newSlimes;
        }
        return new ArrayList<>();
    }

    /**
     * Method, which draws the slime
     * @param g2 - allows to draw images
     */
    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(this.image, this.getX(), this.getY(), 50, 50, null);
    }
}
