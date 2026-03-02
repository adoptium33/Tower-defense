import java.util.ArrayList;

/**
 * Class, which manage the Tower
 */
public class Tower {
    private int hp;
    private int maxHp;
    private int priceOfLvl;
    private int lvl;

    private ArrayList<Knight> knights;
    private ArrayList<Warior> wariors;

    /**
     * Constructor
     */
    public Tower() {
        this.hp = 400;
        this.maxHp = hp;
        this.lvl = 1;
        this.priceOfLvl = 70;

        this.knights = new ArrayList<>();
        this.wariors = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            this.knights.add(new Knight());
            this.wariors.add(new Warior());
        }

    }

    /**
     * Tower losses it's hp
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
        this.maxHp += 100;
        this.hp += 100;
        for (Knight knight : this.knights) {
            knight.lvlUp();
        }
        for (Warior warior : wariors) {
            warior.lvlUp();
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
            this.priceOfLvl = 120;
        }
        if (this.lvl > 50) {
            this.priceOfLvl = 150;
        }
    }

    /**
     * Method, which adds 1 more knight
     */
    public void addKnight() {
        this.knights.add(new Knight());
    }

    /**
     * Method, which adds 1 more warior
     */
    public void addWarior() {
        this.wariors.add(new Warior());
    }

    /**
     * Geters
     * @return
     */
    public int getPriceOfLvl() {
        return this.priceOfLvl;
    }
}
