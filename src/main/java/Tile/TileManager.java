package Tile;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.Random;

public class TileManager extends Tile {
    GamePanel gp;
    public Tile[] tiles;
    public int[][] mapTileNum;
    Random random = new Random();
    int mapCount = 2;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tiles = new Tile[30];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        int mapRandomNum = random.nextInt(mapCount) + 1;

        getTileImage();
        drawMap("src/main/resources/map/map" + mapRandomNum + ".txt");
    }

    public void getTileImage() {
        try {
            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/grass.png")));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/water.png")));
            tiles[1].collision = true;

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/flower.png")));

            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/flowers.png")));

            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/stump.png")));
            tiles[4].collision = true;

            tiles[5] = new Tile();
            tiles[5].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/up.png")));

            tiles[6] = new Tile();
            tiles[6].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/down.png")));
            tiles[6].collision = true;

            tiles[7] = new Tile();
            tiles[7].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/right.png")));

            tiles[8] = new Tile();
            tiles[8].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/left.png")));

            tiles[9] = new Tile();
            tiles[9].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/upright.png")));

            tiles[10] = new Tile();
            tiles[10].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/upleft.png")));

            tiles[11] = new Tile();
            tiles[11].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/downright.png")));
            tiles[11].collision = true;

            tiles[12] = new Tile();
            tiles[12].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/downleft.png")));
            tiles[12].collision = true;

            tiles[13] = new Tile();
            tiles[13].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/destroyable1.png")));
            tiles[13].collision = true;

            tiles[14] = new Tile();
            tiles[14].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/destroyable2.png")));
            tiles[14].collision = true;

            tiles[15] = new Tile();
            tiles[15].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/destroyable1up.png")));
            tiles[15].collision = true;

            tiles[16] = new Tile();
            tiles[16].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/destroyable1right.png")));
            tiles[16].collision = true;

            tiles[17] = new Tile();
            tiles[17].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/destroyable1left.png")));
            tiles[17].collision = true;

            tiles[18] = new Tile();
            tiles[18].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/destroyable2up.png")));
            tiles[18].collision = true;

            tiles[19] = new Tile();
            tiles[19].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/destroyable2right.png")));
            tiles[19].collision = true;

            tiles[20] = new Tile();
            tiles[20].image = ImageIO.read((new FileInputStream("src/main/resources/tiles/destroyable2left.png")));
            tiles[20].collision = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawMap(String filepath) {
        try {
            InputStream inputStream = new FileInputStream(filepath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            for (int row = 0; row < gp.maxScreenRow; row++) {
                String line = reader.readLine();
                for (int col = 0; col < gp.maxScreenCol; col++) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {
        int x = 0;
        int y = 0;

        for (int row = 0; row < gp.maxScreenRow; row++){
            for (int col = 0; col < gp.maxScreenCol; col++){
                int tileNum = mapTileNum[col][row];
                graphics2D.drawImage(tiles[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
                x += gp.tileSize;
            }
            x = 0;
            y += gp.tileSize;
        }
    }
}

