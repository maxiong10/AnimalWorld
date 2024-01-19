package object;

import java.awt.image.BufferedImage;

/**
 * this class is the parent class of all objects
 * 
 * @author maxxiong
 *
 */
public class SuperObject {
  
  public BufferedImage image;
  public String name;
  public boolean collision = false;
  public int worldX, worldY;

}
