package Main;

import Monsters.Enemy;
import Monsters.Skeleton;
import Monsters.Slime;
import Monsters.Zombie;
import Player.Tower;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Class, which has the largest part of game's logic
 */
public class Game extends JPanel implements ActionListener {
    private ArrayList<Enemy> enemies;
    private Tower tower;

    private int wave;
    private int coins;

    private Timer timer;

    /**
     * Constructor
     */
    public Game() {
        this.enemies = new ArrayList<>();
        this.tower = new Tower();

        this.wave = 1;

        this.timer = new Timer(100, this);
        this.timer.start();
    }

    /**
     * Method with main game logic
     */
    public void mainLogic() {
        this.wave();

        Enemy nearest = enemies.get(0);
        for (Enemy enemy : this.enemies) {
            enemy.go(this.tower);
            if (enemy.getX() < nearest.getX()) {
                nearest = enemy;
            }
        }
        this.tower.start(nearest);
    }

    /**
     * Method, which starts the wave
     */
    public void wave() {
        for (int i = 0; i < this.wave + 5; i++) {
            this.enemies.add(new Skeleton());
        }
        for (int i = 0; i < this.wave + 5; i++) {
            this.enemies.add(new Zombie());
        }
        for (int i = 0; i < this.wave + 10; i++) {
            this.enemies.add(new Slime());
        }
        repaint();
    }

    /**
     * Method, which finds out if there are alive monsters
     */
    public void areMonstersAlive() {
        for (int i = this.enemies.size() - 1; i >= 0; i--) {
            if (this.enemies.get(i).isDead()) {
                this.coins += this.enemies.get(i).getPrice();

                ArrayList<Enemy> newEnemies = this.enemies.get(i).deadAction();
                if (!newEnemies.isEmpty() && newEnemies != null) {
                    for (Enemy enemy : newEnemies) {
                        this.enemies.add(enemy);
                    }
                }

                this.enemies.remove(i);
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

    /**
     * Method, which repaint all objects when Timer does a tick
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
