package Main;

import Entity.Entity;
import org.w3c.dom.css.Rect;

import java.awt.*;

public class CheckCollision {
    GamePanel gp;

    public CheckCollision(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {
        int entityLeftX = entity.x + entity.hitBox.x;
        int entityRightX = entity.x + entity.hitBox.x + entity.hitBox.width;
        int entityTopY = entity.y + entity.hitBox.y;
        int entityBotY = entity.y + entity.hitBox.y + entity.hitBox.height;

        int entityLeftCol = entityLeftX / gp.tileSize;
        int entityRightCol = entityRightX / gp.tileSize;
        int entityTopRow = entityTopY / gp.tileSize;
        int entityBotRow = entityBotY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (entity.dir) {
            case "up" -> {
                entityTopRow = (entityTopY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tile.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tile.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tile.tiles[tileNum1].collision || gp.tile.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "down" -> {
                entityBotRow = (entityBotY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tile.mapTileNum[entityLeftCol][entityBotRow];
                tileNum2 = gp.tile.mapTileNum[entityRightCol][entityBotRow];
                if (gp.tile.tiles[tileNum1].collision || gp.tile.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "right" -> {
                entityRightCol = (entityRightX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tile.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tile.mapTileNum[entityRightCol][entityBotRow];
                if (gp.tile.tiles[tileNum1].collision || gp.tile.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "left" -> {
                entityLeftCol = (entityLeftX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tile.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tile.mapTileNum[entityLeftCol][entityBotRow];
                if (gp.tile.tiles[tileNum1].collision || gp.tile.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
        }
    }

    public int checkItem(Entity entity) {
        int index = -1;
        for (int i = 0; i < gp.items.length; i++) {
            if (gp.items[i] != null) {
                entity.hitBox.x = entity.x + entity.hitBox.x;
                entity.hitBox.y = entity.y + entity.hitBox.y;
                gp.items[i].hitBox.x = gp.items[i].x + gp.items[i].hitBox.x;
                gp.items[i].hitBox.y = gp.items[i].y + gp.items[i].hitBox.y;

                switch (entity.dir) {
                    case "up" -> {
                        entity.hitBox.y -= entity.speed;
                    }
                    case "down" -> {
                        entity.hitBox.y += entity.speed;
                    }
                    case "right" -> {
                        entity.hitBox.x += entity.speed;
                    }
                    case "left" -> {
                        entity.hitBox.x -= entity.speed;
                    }
                }
                if (entity.hitBox.intersects(gp.items[i].hitBox)) {
                    index = i;
                }

                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;
                gp.items[i].hitBox.x = gp.items[i].hitBoxDefaultX;
                gp.items[i].hitBox.y = gp.items[i].hitBoxDefaultY;
            }
        }
        return index;
    }

    public int checkEntity(Entity entity, Entity[] enemy) {
        int index = -1;
        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i] != null) {
                entity.hitBox.x = entity.x + entity.hitBox.x;
                entity.hitBox.y = entity.y + entity.hitBox.y;
                enemy[i].hitBox.x = enemy[i].x + enemy[i].hitBox.x;
                enemy[i].hitBox.y = enemy[i].y + enemy[i].hitBox.y;

                switch (entity.dir) {
                    case "up" -> {
                        entity.hitBox.y -= entity.speed;
                    }
                    case "down" -> {
                        entity.hitBox.y += entity.speed;
                    }
                    case "right" -> {
                        entity.hitBox.x += entity.speed;
                    }
                    case "left" -> {
                        entity.hitBox.x -= entity.speed;
                    }
                }
                if (entity.hitBox.intersects(enemy[i].hitBox)) {
                    entity.collisionOn = true;
                    index = i;
                }
                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;
                enemy[i].hitBox.x = enemy[i].hitBoxDefaultX;
                enemy[i].hitBox.y = enemy[i].hitBoxDefaultY;
            }
        }
        return index;
    }

    public boolean checkPlayer(Entity entity) {
        boolean interactPlayer = false;
        entity.hitBox.x = entity.x + entity.hitBox.x;
        entity.hitBox.y = entity.y + entity.hitBox.y;
        gp.player.hitBox.x = gp.player.x + gp.player.hitBox.x;
        gp.player.hitBox.y = gp.player.y + gp.player.hitBox.y;

        switch (entity.dir) {
            case "up" -> {
                entity.hitBox.y -= entity.speed;
            }
            case "down" -> {
                entity.hitBox.y += entity.speed;
            }
            case "right" -> {
                entity.hitBox.x += entity.speed;
            }
            case "left" -> {
                entity.hitBox.x -= entity.speed;
            }
        }
        if (entity.hitBox.intersects(gp.player.hitBox)) {
            entity.collisionOn = true;
            interactPlayer = true;
        }
        entity.hitBox.x = entity.hitBoxDefaultX;
        entity.hitBox.y = entity.hitBoxDefaultY;
        gp.player.hitBox.x = gp.player.hitBoxDefaultX;
        gp.player.hitBox.y = gp.player.hitBoxDefaultY;

        return interactPlayer;
    }

    public void flameCheckWall(Entity flame) {
        int tileNum;
        if (gp.player.potionCount == 0) {
            tileNum = gp.tile.mapTileNum[flame.x / gp.tileSize][flame.y / gp.tileSize];
            if (gp.tile.tiles[tileNum].collision) {
                flame.alive = false;
            }
        }
        if (gp.player.potionCount == 1) {

        }
    }


    public void playerCheckBomb() {
        for (int i = 0; i < gp.bombList.size(); i++) {
            if (gp.bombList.get(i) != null) {
                int distance = (int) Math.sqrt(Math.pow(gp.player.x - gp.bombList.get(i).x, 2)
                        + Math.pow(gp.player.y - gp.bombList.get(i).y, 2));
                if (distance >= gp.tileSize) {
                    gp.bombList.get(i).bombCollisionToPlayer = true;
                }
                if (gp.bombList.get(i).bombCollisionToPlayer) {
                    gp.player.hitBox.x = gp.player.x + gp.player.hitBox.x;
                    gp.player.hitBox.y = gp.player.y + gp.player.hitBox.y;
                    gp.bombList.get(i).hitBox.x = gp.bombList.get(i).x + gp.bombList.get(i).hitBox.x;
                    gp.bombList.get(i).hitBox.y = gp.bombList.get(i).y + gp.bombList.get(i).hitBox.y;

                    switch (gp.player.dir) {
                        case "up" -> {
                            gp.player.hitBox.y -= gp.player.speed;
                        }
                        case "down" -> {
                            gp.player.hitBox.y += gp.player.speed;
                        }
                        case "right" -> {
                            gp.player.hitBox.x += gp.player.speed;
                        }
                        case "left" -> {
                            gp.player.hitBox.x -= gp.player.speed;
                        }
                    }

                    if (gp.player.hitBox.intersects(gp.bombList.get(i).hitBox)) {
                        gp.player.collisionOn = true;
                    }
                    gp.player.hitBox.x = gp.player.hitBoxDefaultX;
                    gp.player.hitBox.y = gp.player.hitBoxDefaultY;
                    gp.bombList.get(i).hitBox.x = gp.bombList.get(i).hitBoxDefaultX;
                    gp.bombList.get(i).hitBox.y = gp.bombList.get(i).hitBoxDefaultY;
                }
            }
        }
    }

    public void entityCheckBomb(Entity entity) {
        for (int i = 0; i < gp.bombList.size(); i++) {
            if (gp.bombList.get(i) != null) {
//                int distance = (int) Math.sqrt(Math.pow(entity.x - gp.bombList.get(i).x, 2)
//                        + Math.pow(entity.y - gp.bombList.get(i).y, 2));
//                if (distance >= gp.tileSize) {
//                    entity.bombCollisionToEntity = true;
//                }
//                if (entity.bombCollisionToEntity) {
                entity.hitBox.x = entity.x + entity.hitBox.x;
                entity.hitBox.y = entity.y + entity.hitBox.y;
                gp.bombList.get(i).hitBox.x = gp.bombList.get(i).x + gp.bombList.get(i).hitBox.x;
                gp.bombList.get(i).hitBox.y = gp.bombList.get(i).y + gp.bombList.get(i).hitBox.y;

                switch (entity.dir) {
                    case "up" -> {
                        entity.hitBox.y -= entity.speed;
                    }
                    case "down" -> {
                        entity.hitBox.y += entity.speed;
                    }
                    case "right" -> {
                        entity.hitBox.x += entity.speed;
                    }
                    case "left" -> {
                        entity.hitBox.x -= entity.speed;
                    }
                }
                if (entity.hitBox.intersects(gp.bombList.get(i).hitBox)) {
                    entity.collisionOn = true;
                }
                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;
                gp.bombList.get(i).hitBox.x = gp.bombList.get(i).hitBoxDefaultX;
                gp.bombList.get(i).hitBox.y = gp.bombList.get(i).hitBoxDefaultY;
//                }
            }
        }
    }

    public void entityCheckEntity(Entity entity, Entity[] entities) {
        for (int i = 0; i < entities.length; i++) {
            if (entities[i] != null) {
                entity.hitBox.x = entity.x + entity.hitBox.x;
                entity.hitBox.y = entity.y + entity.hitBox.y;
                entities[i].hitBox.x = entities[i].x + entities[i].hitBox.x;
                entities[i].hitBox.y = entities[i].y + entities[i].hitBox.y;

                switch (entity.dir) {
                    case "up" -> {
                        entity.hitBox.y -= entity.speed;
                    }
                    case "down" -> {
                        entity.hitBox.y += entity.speed;
                    }
                    case "right" -> {
                        entity.hitBox.x += entity.speed;
                    }
                    case "left" -> {
                        entity.hitBox.x -= entity.speed;
                    }
                }
                if (entity.hitBox.intersects(entities[i].hitBox)) {
                    entity.collisionOn = true;
                }

                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;
                entities[i].hitBox.x = entities[i].hitBoxDefaultX;
                entities[i].hitBox.y = entities[i].hitBoxDefaultY;
            }
        }
    }

    public boolean bombCheckEntity(int bombX, int bombY, Entity[] entities) {
        for (int i = 0; i < entities.length; i++) {
            if (entities[i] != null) {
                entities[i].hitBox.x = entities[i].x + entities[i].hitBox.x;
                entities[i].hitBox.y = entities[i].y + entities[i].hitBox.y;
                Rectangle rect = new Rectangle(bombX, bombY, 48, 48);
                if (rect.intersects(entities[i].hitBox)) {
                    return true;
                }
                entities[i].hitBox.x = entities[i].hitBoxDefaultX;
                entities[i].hitBox.y = entities[i].hitBoxDefaultY;
            }
        }
        return false;
    }

    public int checkBrick(Entity entity) {
        int index = -1;
        for (int i = 0; i < gp.brick.length; i++) {
            if (gp.brick[i] != null) {
                entity.hitBox.x = entity.x + entity.hitBox.x;
                entity.hitBox.y = entity.y + entity.hitBox.y;
                gp.brick[i].hitBox.x = gp.brick[i].x + gp.brick[i].hitBox.x;
                gp.brick[i].hitBox.y = gp.brick[i].y + gp.brick[i].hitBox.y - 1;

                switch (entity.dir) {
                    case "up" -> {
                        entity.hitBox.y -= entity.speed;
                    }
                    case "down" -> {
                        entity.hitBox.y += entity.speed;
                    }
                    case "right" -> {
                        entity.hitBox.x += entity.speed;
                    }
                    case "left" -> {
                        entity.hitBox.x -= entity.speed;
                    }
                }
                if (entity.hitBox.intersects(gp.brick[i].hitBox)) {
                    index = i;
                    entity.collisionOn = true;
                }

                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;
                gp.brick[i].hitBox.x = 0;
                gp.brick[i].hitBox.y = 0;
            }
        }
        return index;
    }

    public int flameCheckBrick(Entity entity) {
        int index = -1;
        for (int i = 0; i < gp.brick.length; i++) {
            if (gp.brick[i] != null) {
                entity.hitBox.x = entity.x + entity.hitBox.x;
                entity.hitBox.y = entity.y + entity.hitBox.y;
                gp.brick[i].hitBox.x = gp.brick[i].x + gp.brick[i].hitBox.x;
                gp.brick[i].hitBox.y = gp.brick[i].y + gp.brick[i].hitBox.y;

                if (entity.hitBox.intersects(gp.brick[i].hitBox)) {
                    index = i;
                    entity.collisionOn = true;
                }

                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;
                gp.brick[i].hitBox.x = 0;
                gp.brick[i].hitBox.y = 0;
            }
        }
        return index;
    }
}
