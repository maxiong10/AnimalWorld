package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import entity.Player;
import tile.TileManager;

/**
 * this class is the game window upon which the game will be played
 * 
 * @author maxxiong
 *
 */
public class GamePanel extends JPanel implements Runnable {

  // SCREEN SETTINGS
  final int originalTileSize = 32; // 32x32 tile
  final int scale = 2;

  public final int tileSize = originalTileSize * scale; // 64x64 tile
  public final int maxScreenCol = 16;
  public final int maxScreenRow = 12;
  public final int screenWidth = tileSize * maxScreenCol; // 1024 pixels
  public final int screenHeight = tileSize * maxScreenRow; // 768 pixels

  // WORLD SETTINGS
  public final int maxWorldCol = 100; // world column size
  public final int maxWorldRow = 100; // world row size
  public final int worldWidth = tileSize * maxWorldCol;
  public final int worldHeight = tileSize * maxWorldRow;

  // FPS
  int FPS = 60;

  TileManager tileM = new TileManager(this);
  KeyHandler keyH = new KeyHandler();
  Thread gameThread;
  public CollisionChecker cChecker = new CollisionChecker(this);
  public UI ui = new UI(this);
  public Player player = new Player(this, keyH);

  /**
   * this is the constructor the gamePanel
   */
  public GamePanel() {

    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setBackground(Color.black);
    this.setDoubleBuffered(true);
    this.addKeyListener(keyH);
    this.setFocusable(true);
  }

  /**
   * this starts the gameThread
   */
  public void startGameThread() {

    gameThread = new Thread(this);
    gameThread.start();
  }

  /**
   * this method creates the 60 FPS game loop
   */
  @Override
  public void run() {

    double drawInterval = 1000000000 / FPS;
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    long timer = 0;
    int drawCount = 0;

    while (gameThread != null) {

      currentTime = System.nanoTime();

      delta += (currentTime - lastTime) / drawInterval;
      timer += (currentTime - lastTime);
      lastTime = currentTime;

      if (delta >= 1) {
        update();
        repaint();
        delta--;
        drawCount++;
      }

      if (timer >= 1000000000) {
        System.out.println("FPS: " + drawCount);
        drawCount = 0;
        timer = 0;
      }

    }

  }

  /**
   * this class will update the game's window
   */
  public void update() {

    player.update();
  }

  /**
   * this class will draw the window with the updated information
   */
  public void paintComponent(Graphics g) {

    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    tileM.draw(g2); // draws tiles first

    player.draw(g2); // draws player 2nd in order to keep it on top of player
    
    ui.draw(g2); // draws UI 3rd

    g2.dispose();
  }
}
