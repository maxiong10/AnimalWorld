package entity;

import main.KeyHandler;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

/**
 * this is a place holder class for now for the player may be adjusted in the future so multiple
 * characters can be played
 * 
 * @author maxxiong
 *
 */
public class Player extends Entity {

  GamePanel gp;
  KeyHandler keyH;

  public final int screenX;
  public final int screenY;

  /**
   * this constructor is for the player
   * 
   * @param gp   the GamePanel which the player will be drawn to
   * @param keyH the KeyHandler for the player
   */
  public Player(GamePanel gp, KeyHandler keyH) {

    this.gp = gp;
    this.keyH = keyH;

    screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
    screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

    solidArea = new Rectangle(8, 16, 32, 32);

    setDefaultValues();
    getPlayerImage();

  }

  /**
   * this method sets the spawn location and player values
   */
  public void setDefaultValues() {

    worldX = gp.tileSize * 50;
    worldY = gp.tileSize * 50;
    speed = 4;
    direction = "down";
  }

  /**
   * this method gets presley's sprite and loads it in
   */
  public void getPlayerImage() {

    try {

      left1 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Left_1.png"));
      left2 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Left_2.png"));
      left3 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Left_3.png"));
      left4 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Left_3.png"));
      left5 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Left_4.png"));
      right1 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Right_1.png"));
      right2 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Right_2.png"));
      right3 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Right_3.png"));
      right4 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Right_4.png"));
      right5 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Right_5.png"));
      up1 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Up_1.png"));
      up2 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Up_2.png"));
      up3 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Up_3.png"));
      up4 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Up_3.png"));
      up5 = ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Up_4.png"));
      down1 =
          ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Down_v2_1.png"));
      down2 =
          ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Down_v2_2.png"));
      down3 =
          ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Down_v2_3.png"));
      down4 =
          ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Down_v2_4.png"));
      down5 =
          ImageIO.read(getClass().getResourceAsStream("/presley/Presley_Sprites_Down_v2_5.png"));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * this method sets Presley's position and animation
   */
  public void update() {

    if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true
        || keyH.rightPressed == true) {
      if (keyH.upPressed == true) {
        direction = "up";
      } else if (keyH.downPressed == true) {
        direction = "down";
      } else if (keyH.leftPressed == true) {
        direction = "left";
      } else if (keyH.rightPressed == true) {
        direction = "right";
      }

      // CHECK TILE COLLISION
      collisionOn = false;
      gp.cChecker.checkTile(this);

      // IF COLLISION IS FALSE, PLAYER CAN MOVE
      if (collisionOn == false) {

        switch (direction) {
          case "up":
            worldY -= speed;
            break;
          case "down":
            worldY += speed;
            break;
          case "left":
            worldX -= speed;
            break;
          case "right":
            worldX += speed;
            break;
        }
      }

      // ANIMATION DATA
      spriteCounter++;
      if (spriteCounter > 5) {
        if (spriteNum == 1) {
          spriteNum = 2;
        } else if (spriteNum == 2) {
          spriteNum = 3;
        } else if (spriteNum == 3) {
          spriteNum = 4;
        } else if (spriteNum == 4) {
          spriteNum = 5;
        } else if (spriteNum == 5) {
          spriteNum = 1;
        }
        spriteCounter = 0;
      }
    }

  }

  /**
   * this method draws the player sprite to the GamePanel
   * 
   * @param g2
   */
  public void draw(Graphics2D g2) {

    BufferedImage image = null;

    // DRAWING THE ANIMATION
    switch (direction) {
      case "left":
        if (spriteNum == 1) {
          image = left1;
        }
        if (spriteNum == 2) {
          image = left2;
        }
        if (spriteNum == 3) {
          image = left3;
        }
        if (spriteNum == 4) {
          image = left4;
        }
        if (spriteNum == 5) {
          image = left5;
        }
        break;
      case "right":
        if (spriteNum == 1) {
          image = right1;
        }
        if (spriteNum == 2) {
          image = right2;
        }
        if (spriteNum == 3) {
          image = right3;
        }
        if (spriteNum == 4) {
          image = right4;
        }
        if (spriteNum == 5) {
          image = right5;
        }
        break;
      case "up":
        if (spriteNum == 1) {
          image = up1;
        }
        if (spriteNum == 2) {
          image = up2;
        }
        if (spriteNum == 3) {
          image = up3;
        }
        if (spriteNum == 4) {
          image = up4;
        }
        if (spriteNum == 5) {
          image = up5;
        }
        break;
      case "down":
        if (spriteNum == 1) {
          image = down1;
        }
        if (spriteNum == 2) {
          image = down2;
        }
        if (spriteNum == 3) {
          image = down3;
        }
        if (spriteNum == 4) {
          image = down4;
        }
        if (spriteNum == 5) {
          image = down5;
        }
        break;
    }
    g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

  }
}
