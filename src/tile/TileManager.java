package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    GamePanel gamePanel;
    Tile[] tile;
    int[][] mapTileNumber;

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tile = new Tile[10];
        mapTileNumber = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];
        getTileImage();
        loadMap("resources/maps/world01.txt");
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new File("resources/tiles/grass01.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new File("resources/tiles/wall.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new File("resources/tiles/water01.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(new File("resources/tiles/earth.png"));
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(new File("resources/tiles/tree.png"));
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(new File("resources/tiles/road00.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            int col = 0;
            int row = 0;

            while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {
                String line = bufferedReader.readLine();
                while(col < gamePanel.maxWorldCol) {
                    String[] numbers = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNumber[col][row] = num;
                    col++;
                }
                if(col == gamePanel.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0, worldRow = 0;

        while(worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow) {

            int tileNum = mapTileNumber[worldCol][worldRow];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            /*
            0,0 -> canto superior esquerdo (on screen)
            screenX, screenY -> player position on screen

            worldX, worldY -> variables that run through all tiles on the world

            gamePanel worldX, worldY ->
             */
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            g2.drawImage(tile[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
            worldCol++;

            if(worldCol == gamePanel.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
