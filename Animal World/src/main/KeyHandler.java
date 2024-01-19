package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * this class is for the key inputs to be read
 * 
 * @author maxxiong
 *
 */
public class KeyHandler implements KeyListener {

  public boolean upPressed, downPressed, leftPressed, rightPressed;

  /**
   * unused method
   */
  @Override
  public void keyTyped(KeyEvent e) {
  }

  /**
   * this method checks if the key is pressed or not
   */
  @Override
  public void keyPressed(KeyEvent e) {

    int code = e.getKeyCode();

    if (code == KeyEvent.VK_W) {
      upPressed = true;
    }

    if (code == KeyEvent.VK_S) {
      downPressed = true;
    }

    if (code == KeyEvent.VK_A) {
      leftPressed = true;
    }

    if (code == KeyEvent.VK_D) {
      rightPressed = true;
    }

  }

  /**
   * this method checks if the key is pressed or not
   */
  @Override
  public void keyReleased(KeyEvent e) {

    int code = e.getKeyCode();

    if (code == KeyEvent.VK_W) {
      upPressed = false;
    }

    if (code == KeyEvent.VK_S) {
      downPressed = false;
    }

    if (code == KeyEvent.VK_A) {
      leftPressed = false;
    }

    if (code == KeyEvent.VK_D) {
      rightPressed = false;
    }

  }

}
