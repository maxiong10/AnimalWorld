package main;

import entity.Entity;

/**
 * this class checks for collision properties of all tiles and objects and entities in game
 * 
 * @author maxxiong
 *
 */
public class CollisionChecker {

  GamePanel gp;

  /**
   * constructor
   * 
   * @param gp GamePanel of the game
   */
  public CollisionChecker(GamePanel gp) {
    this.gp = gp;
  }

  /**
   * this method checks for collision and stops movement if collision is detected
   * 
   * @param entity the entity which collision is checked for
   */
  public void checkTile(Entity entity) {

    int entityLeftWorldX = entity.worldX + entity.solidArea.x;
    int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
    int entityTopWorldY = entity.worldY + entity.solidArea.y;
    int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

    int entityLeftCol = entityLeftWorldX / gp.tileSize;
    int entityRightCol = entityRightWorldX / gp.tileSize;
    int entityTopRow = entityTopWorldY / gp.tileSize;
    int entityBottomRow = entityBottomWorldY / gp.tileSize;

    int tileNum1, tileNum2;

    switch (entity.direction) {
      case "up":
        entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
        tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
        tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
        if (gp.tileM.tile[tileNum1].collision == true
            || gp.tileM.tile[tileNum2].collision == true) {
          entity.collisionOn = true;
        }
        break;
      case "down":
        entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
        tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
        tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
        if (gp.tileM.tile[tileNum1].collision == true
            || gp.tileM.tile[tileNum2].collision == true) {
          entity.collisionOn = true;
        }
        break;
      case "left":
        entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
        tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
        tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
        if (gp.tileM.tile[tileNum1].collision == true
            || gp.tileM.tile[tileNum2].collision == true) {
          entity.collisionOn = true;
        }
        break;
      case "right":
        entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
        tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
        tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
        if (gp.tileM.tile[tileNum1].collision == true
            || gp.tileM.tile[tileNum2].collision == true) {
          entity.collisionOn = true;
        }
        break;
    }
  }
}
