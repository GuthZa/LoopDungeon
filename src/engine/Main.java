package engine;


import Models.GameItem;
import Models.LivingEntity;
import Models.Player;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Engine game = new Engine();


        obj.setBounds(50, 50, 710, 600);
        obj.setTitle("Drant Deepest Dungeon");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(game);

        GameItem item = new GameItem(GameItem.ItemCategory.Consumable, 10, "water");
        Player entity = new Player("YES", 5, item, 0);
        System.out.println(entity.getExperiencePoints());
    }

}
