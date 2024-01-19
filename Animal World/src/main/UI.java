package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * this class is for the UI of the game
 * 
 * @author maxxiong
 *
 */
public class UI {
  
  GamePanel gp;
  Font arial_40;
  public boolean messageOn = false;
  public String message = "";
  
  public UI(GamePanel gp) {
    this.gp = gp;
    
    // instantiate the fond in constructor to save memory
    arial_40 = new Font("Arial", Font.PLAIN, 40);
  }
  
  public void showMessage(String text) {
    message = text;
    messageOn = true;
  }
  
  public void draw(Graphics2D g2) {
    
    g2.setFont(arial_40);
    g2.setColor(Color.white);
    g2.drawString("test", 50, 50);
  }

}
