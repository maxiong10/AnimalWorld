package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * this class defines an entity, which is a base class for all entities in game
 * 
 * @author maxxiong
 *
 */
public class Entity {

  public int worldX, worldY;
  public int speed;

  public BufferedImage left1, left2, left3, left4, left5, right1, right2, right3, right4, right5,
      up1, up2, up3, up4, up5, down1, down2, down3, down4, down5;
  public String direction;

  public int spriteCounter = 0;
  public int spriteNum = 1;
  
  public Rectangle solidArea;
  public boolean collisionOn = false;
}
