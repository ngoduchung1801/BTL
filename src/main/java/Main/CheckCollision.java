package Main;

import Entity.Entity;

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

    public int checkItem(Entity entity, boolean player) {
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
                    if (gp.items[i].collision) {
                        entity.collisionOn = true;
                    }
                    if (player) {
                        index = i;
                    }
                }

                entity.hitBox.x = entity.hitBoxDefaultX;
                entity.hitBox.y = entity.hitBoxDefaultY;
                gp.items[i].hitBox.x = 0;
                gp.items[i].hitBox.y = 0;
            }

        }
        return index;
    }

    public int checkEntity(Entity entity, Entity[] enemy) {
        int index = -1;
        for (int i = 0; i < gp.enemy.length; i++) {
            if (gp.enemy[i] != null) {
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
}
