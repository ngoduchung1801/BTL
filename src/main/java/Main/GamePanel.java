package Main;

import Entity.BombSpawn;
import Entity.Entity;
import Entity.Player;
import Item.BombToUse;
import Tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

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
    KeyControl keyC = new KeyControl(this);
    Sound sound = new Sound();
    public Thread gameThread;
    public CheckCollision CC = new CheckCollision(this);
    Setup setup = new Setup(this);
    UI ui = new UI(this);
    public Player player = new Player(this, keyC);
    public Entity[] items = new Entity[10];
    public Entity[] enemy = new Entity[10];
    public Entity[] brick = new Entity[50];
    public Entity[] monster = new Entity[10];
    public ArrayList<Entity> entityArrayList = new ArrayList<>();
    public ArrayList<Entity> bombList = new ArrayList<>();
    public ArrayList<Entity> flameList = new ArrayList<>();
    public int gameState;
    public final int pauseState = 0;
    public final int playState = 1;
    public final int titleState = 2;
    public final int endState = 3;
    public final int winState = 4;
    public final int stage2State = 5;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyC);
        this.setFocusable(true);
    }

    public void setUp() {
        gameState = titleState;

        setup.setItem();
        setup.setEnemy();
        setup.setBrick_1();
        playSound(0);
    }

    public void restart() {
        for (int i = 0; i < flameList.size(); i++) {
            if (flameList.get(i) != null) {
                flameList.get(i).alive = false;
            }
        }
        for (int i = 0; i < bombList.size(); i++) {
            if (bombList.get(i) != null) {
                bombList.get(i).alive = false;
            }
        }
        for (int i = 0; i < monster.length; i++) {
            if (monster[i] != null) {
                monster[i] = null;
            }
        }
        for (int i = 0; i < brick.length; i++) {
            if (brick[i] != null) {
                brick[i] = null;
            }
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                items[i] = null;
            }
        }
        player.setDefaultValues();
        setup.setEnemy();
        setup.setItem();
        setup.setBrick_1();
    }

    public void stage2SetUp() {
        for (int i = 0; i < flameList.size(); i++) {
            if (flameList.get(i) != null) {
                flameList.get(i).alive = false;
            }
        }
        for (int i = 0; i < bombList.size(); i++) {
            if (bombList.get(i) != null) {
                bombList.get(i).alive = false;
            }
        }
        for (int i = 0; i < brick.length; i++) {
            if (brick[i] != null) {
                brick[i] = null;
            }
        }
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                items[i] = null;
            }
        }
        player.stage2DefaultValues();
        setup.setMonster();
        setup.setItem_2();
        setup.setBrick_2();
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
        if (gameState == playState || gameState == stage2State) {
            if (player.introTime < 0) {
                player.update();

                for (int i = 0; i < enemy.length; i++) {
                    if (enemy[i] != null) {
                        enemy[i].update();
                    }
                }
                for (int i = 0; i < monster.length; i++) {
                    if (monster[i] != null) {
                        monster[i].update();
                    }
                }
                for (int i = 0; i < bombList.size(); i++) {
                    if (bombList.get(i) != null) {
                        if (bombList.get(i).alive) {
                            bombList.get(i).update();
                        }
                        if (!bombList.get(i).alive) {
                            bombList.remove(i);
                            player.bombCount++;
                        }
                    }
                }
                for (int i = 0; i < flameList.size(); i++) {
                    if (flameList.get(i) != null) {
                        if (flameList.get(i).alive) {
                            flameList.get(i).update();
                        }
                        if (!flameList.get(i).alive) {
                            flameList.remove(i);
                        }
                    }
                }
            } else {
                player.introTime--;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (gameState == titleState) {
            ui.draw(g2);
        } else {
            tile.draw(g2);
            entityArrayList.add(player);

            for (int i = 0; i < items.length; i++) {
                if (items[i] != null) {
                    entityArrayList.add(items[i]);
                }
            }
            for (int i = 0; i < brick.length; i++) {
                if (brick[i] != null) {
                    entityArrayList.add(brick[i]);
                }
            }
            for (int i = 0; i < enemy.length; i++) {
                if (enemy[i] != null) {
                    entityArrayList.add(enemy[i]);
                }
            }
            for (int i = 0; i < monster.length; i++) {
                if (monster[i] != null) {
                    entityArrayList.add(monster[i]);
                }
            }
            for (int i = 0; i < bombList.size(); i++) {
                if (bombList.get(i) != null) {
                    entityArrayList.add(bombList.get(i));
                }
            }
            for (int i = 0; i < flameList.size(); i++) {
                if (flameList.get(i) != null) {
                    entityArrayList.add(flameList.get(i));
                }
            }

            entityArrayList.sort(new Comparator<Entity>() {
                @Override
                public int compare(Entity o1, Entity o2) {
                    return Integer.compare(o1.y, o2.y);
                }
            });

            for (int i = 0; i < entityArrayList.size(); i++) {
                entityArrayList.get(i).draw(g2);
            }
            entityArrayList.clear();

            ui.draw(g2);
            g2.dispose();
        }
    }

    public void playSound(int i) {
        sound.setSound(i);
        sound.play();
        if (i == 0) {
            sound.loop();
        }
    }

    public void playSoundEffect(int i) {
        sound.setSound(i);
        sound.play();
    }
}