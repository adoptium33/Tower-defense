package main;

import monsters.Enemy;
import monsters.Skeleton;
import monsters.Slime;
import monsters.Zombie;
import player.Knight;
import player.Tower;
import player.Warrior;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class, which has the largest part of game's logic
 */
public class Game extends JPanel implements ActionListener {
    private ArrayList<Enemy> enemies;
    private Tower tower;

    private int wave;
    private int coins;
    private boolean start;

    private BufferedImage background;

    private JButton startButton;
    private JButton towerLvlUpButton;
    private JButton addWarriorButton;
    private JButton addKnightButton;
    private JButton superHitButton;

    private JLabel waveLabel;
    private JLabel infoLabel;
    private JLabel coinsLabel;
    private JLabel towerHpLabel;
    private JLabel towerLvlUpLabel;
    private JLabel addWarriorLabel;
    private JLabel addKnightLabel;

    /**
     * Constructor
     */
    public Game() {
        this.enemies = new ArrayList<>();
        this.tower = new Tower();
        this.wave = 0;
        this.coins = 0;
        this.start = false;

        this.setPreferredSize(new Dimension(1400, 800));
        try {
            this.background = ImageIO.read(getClass().getResource("/background.png"));
        } catch (IOException e) {
            this.background = null;
            System.out.println("Wrong path to background file");
        }



        //BUTTONS AND LABELS
        this.setLayout(null);

        this.startButton = new JButton("Start wave");
        this.startButton.setBounds(1230, 710, 150, 75);
        this.startButton.addActionListener( e -> {
            this.wave();
            this.startButton.setEnabled(false);
        });
        this.add(this.startButton);

        this.towerLvlUpButton = new JButton("Tower lvl up");
        this.towerLvlUpButton.setBounds(20, 20, 150, 50);
        this.towerLvlUpButton.addActionListener( e -> {
            this.towerLvlUp();
            this.towerLvlUpLabel.setText("Price: " + this.tower.getPriceOfLvl());
        });
        this.add(this.towerLvlUpButton);

        this.addWarriorButton = new JButton("Add warrior");
        this.addWarriorButton.setBounds(190, 20, 150, 50);
        this.addWarriorButton.addActionListener( e -> {
            this.addWarrior();
        });
        this.add(this.addWarriorButton);

        this.addKnightButton = new JButton("Add knight");
        this.addKnightButton.setBounds(360, 20, 150, 50);
        this.addKnightButton.addActionListener( e -> {
            this.addKnight();
        });
        this.add(this.addKnightButton);

        this.superHitButton = new JButton("Super hit (60 seconds)");
        this.superHitButton.setBounds(1220, 20, 170, 75);
        this.superHitButton.addActionListener( e -> {
            this.tower.superHit();
            this.superHitButton.setEnabled(false);
        });
        this.add(this.superHitButton);

        this.waveLabel = new JLabel("Wave: " + this.wave);
        this.waveLabel.setBounds(530, 20, 150, 50);
        this.add(this.waveLabel);

        this.infoLabel = new JLabel("");
        this.infoLabel.setBounds(670, 20, 200, 50);
        this.add(this.infoLabel);

        this.coinsLabel = new JLabel("Coins: " + this.coins);
        this.coinsLabel.setBounds(600, 20, 150, 50);
        this.add(this.coinsLabel);

        this.towerHpLabel = new JLabel(this.tower.getHp() + "/" + this.tower.getMaxHp());
        this.towerHpLabel.setBounds(220, 150, 500, 50);
        this.add(this.towerHpLabel);

        this.towerLvlUpLabel = new JLabel("Price: " + this.tower.getPriceOfLvl());
        this.towerLvlUpLabel.setBounds(70, 70, 150, 50);
        this.add(this.towerLvlUpLabel);

        this.addWarriorLabel = new JLabel("Price: 100");
        this.addWarriorLabel.setBounds(235, 70, 150, 50);
        this.add(this.addWarriorLabel);

        this.addKnightLabel = new JLabel("Price: 100");
        this.addKnightLabel.setBounds(405, 70, 150, 50);
        this.add(this.addKnightLabel);
    }

    /**
     * Start of the game
     */
    public void start() {
        Timer timer = new Timer( 1000, e -> {
            if (this.start) {
                this.tower.start();

                for (Enemy enemy : this.enemies) {
                    boolean areNearHeroes = false;

                    if (enemy.getX() <= this.tower.getX() + 501) {
                        enemy.attack(this.tower);
                    }

                    for (Warrior w : this.tower.getWarriors()) {
                        if (w.getX() >= enemy.getX() - 5 && w.getX() <= enemy.getX() + 50 + 5) {
                            w.attack(enemy);
                            areNearHeroes = true;
                        }
                    }

                    for (Knight k : this.tower.getKnights()) {
                        if (k.getX() >= enemy.getX() - 5 && k.getX() <= enemy.getX() + 50 + 5) {
                            k.attack(enemy);
                            areNearHeroes = true;
                        }
                    }

                    if (!areNearHeroes) {
                        enemy.go(this.tower);
                    } else {
                        enemy.goSlower(this.tower);
                    }
                }

                if (this.enemies.isEmpty()) {
                    this.infoLabel.setText("Victory! Level complete!");
                    this.waveLabel.setText("Wave: " + this.wave);
                    this.superHitButton.setEnabled(true);
                    this.startButton.setEnabled(true);
                    this.tower.toStratPosition();
                    this.tower.setHp();
                    this.start = false;
                }

                if (this.tower.getHp() <= 0) {
                    this.infoLabel.setText("Defeat:( Try again!");
                    this.superHitButton.setEnabled(true);
                    this.startButton.setEnabled(true);
                    this.enemies.clear();
                    this.tower.toStratPosition();
                    this.tower.setHp();
                    this.start = false;
                }
            }
            this.areMonstersAlive();
            this.infoLabel.setText("");
            this.coinsLabel.setText("Coins: " + this.coins);
            this.towerHpLabel.setText(this.tower.getHp() + "/" + this.tower.getMaxHp());
            repaint();
        });

        timer.start();
    }

    /**
     * Method, which starts the wave
     */
    public void wave() {
        int x = 0;
        int y = 0;
        this.wave += 1;
        for (int i = 0; i < this.wave + 1; i++) {
            this.enemies.add(new Skeleton(1300 + x, 600 + y));

            this.enemies.add(new Zombie(1300 + x, 650 - y));

            this.enemies.add(new Slime(1100 + x, 600 + y));
            this.enemies.add(new Slime(1100 + x, 650 - y));

            x += 10;
            if (y > 0) {
                y = -10;
            } else {
                y = 10;
            }
        }
        this.start = true;
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
                if (!newEnemies.isEmpty()) {
                    this.enemies.addAll(newEnemies);
                }

                this.enemies.remove(i);
            }
        }
    }

    /**
     * Method, which increases level of the tower
     */
    public void towerLvlUp() {
        if (this.coins >= this.tower.getPriceOfLvl()) {
            this.tower.lvlUp();
            this.coins -= this.tower.getPriceOfLvl();
            this.tower.changePrice();
        } else {
            this.infoLabel.setText("You don't have enough coins");
        }
    }

    /**
     * Method, which adds 1 more knight
     */
    public void addKnight() {
        if (this.coins >= 100) {
            this.tower.addKnight();
            this.coins -= 100;
        } else {
            this.infoLabel.setText("You don't have enough coins");
        }
    }

    /**
     * Method, which adds 1 more warior
     */
    public void addWarrior() {
        if (this.coins >= 100) {
            this.tower.addWarrior();
            this.coins -= 100;
        } else {
            this.infoLabel.setText("You don't have enough coins");
        }
    }

    /**
     * Method, which repaint all objects when Timer does a tick
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }


    /**
     * Method, that draws all objects to screen
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.drawImage(this.background, 0, 0, 1400, 800, null);

        this.tower.draw(g2);
        for (Enemy enemy : this.enemies) {
            enemy.draw(g2);
        }
    }
}
