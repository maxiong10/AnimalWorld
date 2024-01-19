package main;

import javax.swing.JFrame;

/**
 * this is the main class to run the game
 * 
 * @author maxxiong
 *
 */
public class main {

  public static void main(String[] args) {
    // creating the window
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("Animal World");

    // add gamePanel to the window
    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);
    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);

    gamePanel.startGameThread();
  }

}
