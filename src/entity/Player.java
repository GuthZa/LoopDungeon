package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends LivingEntity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth / 2 - (gamePanel.tileSize / 2);
        screenY = gamePanel.screenHeight / 2 - (gamePanel.tileSize / 2);

        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;


        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gamePanel.tileSize * 23;//player starting position
        worldY = gamePanel.tileSize * 23;
        speed = 4;
        direction = "down";
    }
    public void update() {
        if(keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed) {
            if (keyHandler.upPressed) {
                direction = "up";
            } else if (keyHandler.downPressed) {
                direction = "down";
            } else if (keyHandler.rightPressed) {
                direction = "right";
            } else if(keyHandler.leftPressed){
                direction = "left";
            }

            //check player collision with environment
            collisionOn = false;
            gamePanel.collisionChecker.checkTile(this);

            //if collision is false player can move
            if(!collisionOn) {
                switch (direction) {
                    case "up" -> worldY -= speed;
                    case "down" -> worldY += speed;
                    case "left" -> worldX -= speed;
                    case "right" -> worldX += speed;
                }
            }

            spriteCounter++;
            if (spriteCounter > 15) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);

        BufferedImage image = null;

        switch (direction) {
            case "up" -> {
                if(spriteNum == 1) image = up1;
                if(spriteNum == 2) image = up2;
            }
            case "down" -> {
                if(spriteNum == 1) image = down1;
                if(spriteNum == 2) image = down2;
            }
            case "right" -> {
                if(spriteNum == 1) image = right1;
                if(spriteNum == 2) image = right2;
            }
            case "left" -> {
                if(spriteNum == 1) image = left1;
                if(spriteNum == 2) image = left2;
            }
        }

        g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
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
