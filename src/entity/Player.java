package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends LivingEntity {

    GamePanel gamePanel;
    KeyHandler keyHandler;
    private int ExperiencePoints;
    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void update() {
        if(keyHandler.upPressed) {
            direction = "up";
            y -= speed;
        } else if (keyHandler.downPressed) {
            direction = "down";
            y += speed;
        } else if (keyHandler.rightPressed) {
            direction = "right";
            x += speed;
        } else if (keyHandler.leftPressed) {
            direction = "left";
            x-=speed;
        }
    }

    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up" -> image = up1;
            case "down" -> image = down1;
            case "right" -> image = right1;
            case "left" -> image = left1;
        }

        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }


    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(new FileInputStream("resources/player/boy_up_1.png"));
            up2 = ImageIO.read(new FileInputStream("resources/player/boy_up_2.png"));
            down1 = ImageIO.read(new FileInputStream("resources/player/boy_down_1.png"));
            down2 = ImageIO.read(new FileInputStream("resources/player/boy_down_2.png"));
            left1 = ImageIO.read(new FileInputStream("resources/player/boy_left_1.png"));
            left2 = ImageIO.read(new FileInputStream("resources/player/boy_left_2.png"));
            right1 = ImageIO.read(new FileInputStream("resources/player/boy_right_1.png"));
            right2 = ImageIO.read(new FileInputStream("resources/player/boy_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}