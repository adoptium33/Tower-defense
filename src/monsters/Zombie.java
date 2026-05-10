package monsters;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class, which extends Monsters.Enemy, characterizes a zombie
 */
public class Zombie extends Enemy {
    private BufferedImage image;

    /**
     * Constructor
     */
    public Zombie(int x, int y) {
        super(x, y, 300, 20, 10, 15);
        try {
            this.image = ImageIO.read(getClass().getResource("/zombie/zombieGo1.png"));
        } catch (IOException e) {
            this.image = null;
        }
    }

    /**
     * Action, that zombie does, when dies
     */
    @Override
    public ArrayList<Enemy> deadAction() {
        ArrayList<Enemy> newSkelEton = new ArrayList<>();
        newSkelEton.add(new Skeleton(this.getX(), this.getY()));
        return newSkelEton;
    }

    /**
     * Method, which draws the zombie
     * @param g2 - allows to draw images
     */
    @Override
    public void draw(Graphics2D g2) {
        g2.drawImage(this.image, this.getX(), this.getY(), 50, 50, null);
    }
}
