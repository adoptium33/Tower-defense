import java.util.ArrayList;

/**
 * Class, which has the largest part of game's logic
 */
public class Game {
    private ArrayList<Skeleton> skeletons;
    private ArrayList<Zombie> zombies;
    private ArrayList<Slime> slimes;

    private Tower tower;

    private int wave;
    private int coins;

    /**
     * Constructor
     */
    public Game() {
        this.skeletons = new ArrayList<>();
        this.zombies = new ArrayList<>();
        this.slimes = new ArrayList<>();

        this.tower = new Tower();

        this.wave = 1;
    }

    /**
     * Method, which starts the wave
     */
    public void wave() {

        for (int i = 0; i < this.wave + 5; i++) {
            this.skeletons.add(new Skeleton());
        }
        for (int i = 0; i < this.wave + 5; i++) {
            this.zombies.add(new Zombie());
        }
        for (int i = 0; i < this.wave + 10; i++) {
            this.slimes.add(new Slime());
        }

        //TODO isMonstersAlive logic
    }

    /**
     * Method, which finds out if there are alive monsters
     */
    public void isMonstersAlive() {
        for (int i = this.skeletons.size() - 1; i >= 0; i--) {
            if (this.skeletons.get(i).isDead()) {
                this.coins += this.skeletons.get(i).getPrice();
                this.skeletons.get(i).deadAction();
                this.skeletons.remove(i);
            }
        }

        for (int i = this.zombies.size() - 1; i >= 0; i--) {
            if (this.zombies.get(i).isDead()) {
                this.coins += this.zombies.get(i).getPrice();
                this.skeletons.get(i).deadAction();
                this.zombies.remove(i);
            }
        }

        for (int i = this.slimes.size() - 1; i >= 0; i--) {
            if (this.slimes.get(i).isDead()) {
                this.coins += this.slimes.get(i).getPrice();

                ArrayList<Enemy> newSlimes = this.slimes.get(i).deadAction();
                if (!newSlimes.isEmpty() && newSlimes != null) {
                    for (Enemy slime : newSlimes) {
                        this.slimes.add((Slime) slime);
                    }
                }

                this.slimes.remove(i);
            }
        }
    }

    /**
     * Method, which ends the wave
     */
    public void waveLvlUp() {
        this.wave += 1;
    }

    /**
     * Method, which increases level of the tower
     */
    public void towerLvlUp() {
        if (this.coins >= this.tower.getPriceOfLvl()) {
            this.tower.lvlUp();
            this.coins -= this.tower.getPriceOfLvl();
        }
    }

    /**
     * Method, which adds 1 more knight
     */
    public void addKnight() {
        this.tower.addKnight();
        this.coins -= 100;
    }

    /**
     * Method, which adds 1 more warior
     */
    public void addWarrior() {
        this.tower.addWarrior();
        this.coins -= 100;
    }
}
