package player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class, which manage the Player.Tower
 */
public class Tower {
    private int hp;
    private int maxHp;
    private int priceOfLvl;
    private int lvl;

    private ArrayList<Knight> knights;
    private ArrayList<Warrior> warriors;

    private BufferedImage image;

    /**
     * Constructor
     */
    public Tower() {
        this.hp = 400;
        this.maxHp = this.hp;
        this.lvl = 1;
        this.priceOfLvl = 70;

        this.knights = new ArrayList<>();
        this.warriors = new ArrayList<>();

        int x = 0;
        int y = 10;
        for (int i = 0; i < 5; i++) {
            this.knights.add(new Knight(500 + x, 650 - y));
            this.warriors.add(new Warrior(500 + x, 600 + y));
            x += 10;
            if (y > 0) {
                y = -10;
            } else {
                y = 10;
            }
        }

        try {
            this.image = ImageIO.read(getClass().getResource("/tower.png"));
        } catch  (IOException e) {
            this.image = null;
        }
    }

    /**
     * The start of hero's moving
     */
    public void start() {
        for (Knight knight : this.knights) {
            knight.go();
        }
        for (Warrior warrior : this.warriors) {
            warrior.go();
        }
    }

    /**
     * Player.Tower losses it's hp
     * @param howMuch - how much hp the tower losses
     */
    public void lossHp(int howMuch) {
        this.hp -= howMuch;
    }

    /**
     * Method, which ups level of the tower
     */
    public void lvlUp() {
        this.lvl += 1;
        this.maxHp += 50;
        this.hp += 50;
        for (Knight knight : this.knights) {
            knight.lvlUp();
        }
        for (Warrior warrior : this.warriors) {
            warrior.lvlUp();
        }
    }

    /**
     * Method, that change price to up tower's level
     */
    public void changePrice() {
        if (this.lvl > 10 && this.lvl < 30) {
            this.priceOfLvl = 100;
        }
        if (this.lvl > 30 && this.lvl < 50) {
            this.priceOfLvl = 200;
        }
        if (this.lvl > 50) {
            this.priceOfLvl = 500;
        }
    }

    /**
     * Method, that turn on superhit
     */
    public void superHit() {
        for (Knight knight : this.knights) {
            knight.superHit();
        }
        for (Warrior warrior : this.warriors) {
            warrior.superHit();
        }
    }

    /**
     * Method, which adds 1 more knight
     */
    public void addKnight() {
        this.knights.add(new Knight(500, 650));
    }

    /**
     * Method, which adds 1 more warior
     */
    public void addWarrior() {
        this.warriors.add(new Warrior(500, 600));
    }

    /**
     * Method, which returns all heroes to their start positions
     */
    public void toStratPosition() {
        int x = 0;
        int y = 10;
        for (Knight k : this.knights) {
            k.setX(500 + x);
            k.setY(650 - y);
            x += 10;
            if (y > 0) {
                y = -10;
            } else {
                y = 10;
            }
        }

        x = 0;
        y = 10;
        for (Warrior w : this.warriors) {
            w.setX(500 + x);
            w.setY(600 + y);
            x += 10;
            if (y > 0) {
                y = -10;
            } else {
                y = 10;
            }
        }
    }

    /**
     * Method, which draws tower
     * @param g2 - allows to draw image
     */
    public void draw(Graphics2D g2) {
        g2.drawImage(this.image, 0, 200, 500, 500, null);

        for (Knight k : this.knights) {
            k.draw(g2);
        }
        for (Warrior w : this.warriors) {
            w.draw(g2);
        }
    }

    /**
     * Geters
     * @return
     */
    public int getPriceOfLvl() {
        return this.priceOfLvl;
    }

    public int getX() {
        return 0;
    }

    public ArrayList<Knight> getKnights() {
        return this.knights;
    }

    public ArrayList<Warrior> getWarriors() {
        return this.warriors;
    }

    public int getHp() {
        return this.hp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    /**
     * Setters
     */
    public void setHp() {
        this.hp = this.maxHp;
    }
}
