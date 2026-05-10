package main;

import javax.swing.JFrame;

/**
 * Main.Main class, which starts the program
 */
public class Main {

    /**
     * Method main, which starts the program
     */
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Tower defense game");
        f.setResizable(false);

        Game g = new Game();
        f.add(g);
        f.pack();

        f.setLocationRelativeTo(null);
        f.setVisible(true);

        g.start();
    }
}