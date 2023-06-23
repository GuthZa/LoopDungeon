package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Drant's Deepest Dungeon");

        GamePanel game = new GamePanel();
        window.add(game);

        window.pack(); //causes the window to fit the preferred size and layout of the subcomponent -> GamePanel

        game.startGameThread();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
