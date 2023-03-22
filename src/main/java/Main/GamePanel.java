package Main;

import Entity.Player;
import Item.Item;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    // Screen
    public final int originalTileSize = 16;
    final int Scale = 3;
    public final int tileSize = originalTileSize * Scale;
    public final int maxScreenCol = 17;
    public final int maxScreenRow = 16;
    public final int screenWidth = maxScreenCol * tileSize;
    public final int screenHeight = maxScreenRow * tileSize;

    // FPS
    int FPS = 60;

    // Panel
    TileManager tile = new TileManager(this);
    KeyControl keyC = new KeyControl();
    Thread gameThread;
    public CheckCollision CC = new CheckCollision(this);
    SetObj setObj = new SetObj(this);
    UI ui = new UI(this);
    Player player = new Player(this, keyC);
    public Item[] items = new Item[10];

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyC);
        this.setFocusable(true);
    }

    public void setUp(){
        setObj.setItem();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        tile.draw(g2);

        for (int i = 0; i < items.length; i++){
            if (items[i] != null){
                items[i].draw(g2, this);
            }
        }

        player.draw(g2);

        ui.draw(g2);
        g2.dispose();
    }
}
