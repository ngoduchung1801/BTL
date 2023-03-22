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
            case "up":
                entityTopRow = (entityTopY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tile.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tile.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tile.tiles[tileNum1].collision || gp.tile.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBotRow = (entityBotY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tile.mapTileNum[entityLeftCol][entityBotRow];
                tileNum2 = gp.tile.mapTileNum[entityRightCol][entityBotRow];
                if (gp.tile.tiles[tileNum1].collision || gp.tile.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tile.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tile.mapTileNum[entityRightCol][entityBotRow];
                if (gp.tile.tiles[tileNum1].collision || gp.tile.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tile.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tile.mapTileNum[entityLeftCol][entityBotRow];
                if (gp.tile.tiles[tileNum1].collision || gp.tile.tiles[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
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
                    case "up":
                        entity.hitBox.y -= entity.speed;
                        if (entity.hitBox.intersects(gp.items[i].hitBox)) {
                            if (gp.items[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.hitBox.y += entity.speed;
                        if (entity.hitBox.intersects(gp.items[i].hitBox)) {
                            if (gp.items[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.hitBox.x += entity.speed;
                        if (entity.hitBox.intersects(gp.items[i].hitBox)) {
                            if (gp.items[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.hitBox.x -= entity.speed;
                        if (entity.hitBox.intersects(gp.items[i].hitBox)) {
                            if (gp.items[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                }
                entity.hitBox.x = 16;
                entity.hitBox.y = 28;
                gp.items[i].hitBox.x = 0;
                gp.items[i].hitBox.y = 0;
            }

        }

        return index;
    }
}
