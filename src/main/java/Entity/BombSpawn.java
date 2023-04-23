package Entity;

import Main.GamePanel;

public class BombSpawn extends Entity {
    Entity entity;

    public BombSpawn(GamePanel gp) {

        super(gp);
        flame0 = new Flame(gp);
        flame1 = new Flame(gp);
        flame2 = new Flame(gp);
        flame3 = new Flame(gp);
        flame4 = new Flame(gp);
        flame5 = new Flame(gp);
        flame6 = new Flame(gp);
        flame7 = new Flame(gp);
        flame8 = new Flame(gp);

    }

    public void set(int x, int y, String dir, boolean alive) {
        int bombX = ((x + gp.tileSize / 2) / gp.tileSize) * gp.tileSize;
        int bombY = ((y + gp.tileSize / 2) / gp.tileSize) * gp.tileSize;
//        if (gp.CC.bombCheckEntity(bombX,bombY,gp.enemy)){
//            switch (gp.player.dir) {
//                case "up" -> bombY = ((y + gp.tileSize) / gp.tileSize) * gp.tileSize;
//                case "down" -> bombY = ((y - gp.tileSize / 2) / gp.tileSize) * gp.tileSize;
//                case "right" -> bombX = ((x - gp.tileSize / 2) / gp.tileSize) * gp.tileSize;
//                case "left" -> bombX = ((x + gp.tileSize) / gp.tileSize) * gp.tileSize;
//            }
//        }
        this.x = bombX;
        this.y = bombY;
        this.dir = dir;
        this.alive = alive;
        this.bombLife = this.bombMaxLife;
    }

    public void update() {

        bombLife--;
        if (bombLife > 120) {
            Count++;
            if (Count > 20) {
                if (bombImageNum == 1) {
                    bombImageNum = 2;
                } else if (bombImageNum == 2) {
                    bombImageNum = 1;
                }
                Count = 0;
            }
        } else if (bombLife > 60) {
            Count++;
            if (Count > 6) {
                if (bombImageNum == 1) {
                    bombImageNum = 2;
                } else if (bombImageNum == 2) {
                    bombImageNum = 1;
                }
                Count = 0;
            }
        } else if (bombLife > 0) {
            Count++;
            if (Count > 2) {
                if (bombImageNum == 1) {
                    bombImageNum = 2;
                } else if (bombImageNum == 2) {
                    bombImageNum = 1;
                }
                Count = 0;
            }
        } else {
            if (gp.player.potionCount == 0) {
                flame0.set(x, y + 48, "down", true);
                gp.flameList.add(flame0);

                flame1.set(x + 48, y, "right", true);
                gp.flameList.add(flame1);

                flame2.set(x - 48, y, "left", true);
                gp.flameList.add(flame2);

                flame3.set(x, y - 48, "up", true);
                gp.flameList.add(flame3);

                flame4.set(x, y, "center", true);
                gp.flameList.add(flame4);
            }
            if (gp.player.potionCount == 1) {
                flame0.set(x, y + 96, "down", true);
                gp.flameList.add(flame0);

                flame1.set(x + 96, y, "right", true);
                gp.flameList.add(flame1);

                flame2.set(x - 96, y, "left", true);
                gp.flameList.add(flame2);

                flame3.set(x, y - 96, "up", true);
                gp.flameList.add(flame3);

                flame4.set(x, y + 48, "vertical", true);
                gp.flameList.add(flame4);

                flame5.set(x + 48, y, "horizontal", true);
                gp.flameList.add(flame5);

                flame6.set(x - 48, y, "horizontal", true);
                gp.flameList.add(flame6);

                flame7.set(x, y - 48, "vertical", true);
                gp.flameList.add(flame7);

                flame8.set(x, y, "center", true);
                gp.flameList.add(flame8);
            }

            alive = false;
            bombCollisionToPlayer = false;
            bombCollisionToEntity = false;
        }
    }
}