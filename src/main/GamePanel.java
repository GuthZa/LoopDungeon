package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    final int originalTileSize = 16; //Sprite size
    final int scale = 3; //to scale the pixel to the resolution

    public final int tileSize = originalTileSize * scale; //48x48 pixels
    final int maxScreenCol = 16; //how many tiles can exist in a column
    final int maxScreenRow = 12; //how many tiles can exist in a row
    //these make a 16x12 of 48x48 tiles
    //Resolution: 768x576
    final int screenWidth = tileSize * maxScreenCol; //768 pixels
    final int screenHeight = tileSize * maxScreenRow; //576 pixels

    int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyHandler);

    //Set player settings
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        //To improve performance
        this.setDoubleBuffered(true); //This makes the drawing in a offscreen buffer

        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start(); //this automatically calls run()
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; //draws the screen every 0.16666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;


        while(gameThread!=null) {

            currentTime = System.nanoTime(); //returns time in nanoseconds
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                //Update information
                update();

                //Draw the screen with update information
                repaint(); //calls the painComponent
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        player.draw(g2);

        g2.dispose();
    }
}