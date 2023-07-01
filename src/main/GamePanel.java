package main;

import entity.Player;
import objects.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //Screen Settings
    final int originalTileSize = 16; //Sprite size
    final int scale = 3; //to scale the pixel to the resolution

    public final int tileSize = originalTileSize * scale; //48x48 pixels
    public final int maxScreenCol = 16; //how many tiles can exist in a column
    public final int maxScreenRow = 12; //how many tiles can exist in a row
    //these make a 16x12 of 48x48 tiles
    //Resolution: 768x576
    public final int screenWidth = tileSize * maxScreenCol; //768 pixels
    public final int screenHeight = tileSize * maxScreenRow; //576 pixels

    //World Settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxScreenCol;
    public final int worldHeight = tileSize * maxScreenRow;

    //FPS
    int FPS = 60;

    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    public Player player = new Player(this, keyHandler);
    public SuperObject[] objects = new SuperObject[10];



    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        //To improve performance
        this.setDoubleBuffered(true); //This makes the drawing in a offscreen buffer

        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void setupGame() {
        assetSetter.setObject();
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

        tileManager.draw(g2);
        player.draw(g2);

        
        for (SuperObject object : objects) {
            if (object != null) {
                object.draw(g2, this);
            }
        }

        g2.dispose();
    }
}
