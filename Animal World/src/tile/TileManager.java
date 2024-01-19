package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;

/**
 * this class manages the tiles and map
 * 
 * @author maxxiong
 *
 */
public class TileManager {

  GamePanel gp;
  public Tile[] tile;
  public int mapTileNum[][];

  /**
   * constructor of the tileManager
   * 
   * @param gp the GamePanel which tiles will be drawn to
   */
  public TileManager(GamePanel gp) {

    this.gp = gp;

    tile = new Tile[10]; // size of the Tile array, will need to be increased when more tiles come
                         // in

    mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

    getTileImage();
    loadMap("/maps/TestMap2.txt");
  }

  /**
   * this method is where all the tile images are loaded into the tile array
   */
  public void getTileImage() {

    try {
      // 0. dirt darker tile
      tile[0] = new Tile();
      tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/DirtPath Tile_1.png"));
      // 1. dirt dark tile
      tile[1] = new Tile();
      tile[1].image =
          ImageIO.read(getClass().getResourceAsStream("/tiles/DirtPath_Dark Tile_1.png"));
      // 2. dirt path tile
      tile[2] = new Tile();
      tile[2].image =
          ImageIO.read(getClass().getResourceAsStream("/tiles/DirtPath_Darker Tile_1.png"));
      // 3. Grass_Dark Tile
      tile[3] = new Tile();
      tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass Tile_1.png"));
      // 4. Grass tile
      tile[4] = new Tile();
      tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Grass_Dark Tile_1.png"));
      // 5. Water 1 tile
      tile[5] = new Tile();
      tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Water Tile_Move1.png"));
      tile[5].collision = true;
      // 6. Tree Tile
      tile[6] = new Tile();
      tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Tree Tile_1.png"));
      tile[6].collision = true;
      // 7. Tree Dark Tile
      tile[7] = new Tile();
      tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Tree_Dark Tile_1.png"));
      tile[7].collision = true;
      

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * this method loads the map data from the txt file into the map array
   * 
   * @param filePath the name of the txt file
   */
  public void loadMap(String filePath) {

    try {

      InputStream is = getClass().getResourceAsStream(filePath);
      BufferedReader br = new BufferedReader(new InputStreamReader(is));

      int col = 0;
      int row = 0;

      while (col < gp.maxWorldCol && row < gp.maxWorldRow) {

        String line = br.readLine();

        while (col < gp.maxWorldCol) {

          String numbers[] = line.split(",");

          int num = Integer.parseInt(numbers[col]);

          mapTileNum[col][row] = num;
          col++;
        }
        if (col == gp.maxWorldCol) {
          col = 0;
          row++;
        }
      }
      br.close();

    } catch (Exception e) {

    }
  }

  /**
   * this method draws the tiles from the map onto the screen and controls the camera
   * 
   * @param g2 the graphics
   */
  public void draw(Graphics2D g2) {

    int worldCol = 0;
    int worldRow = 0;

    while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

      int tileNum = mapTileNum[worldCol][worldRow];

      // keeps the camera so the player stays in the middle while moving around the world
      int worldX = worldCol * gp.tileSize;
      int worldY = worldRow * gp.tileSize;
      int screenX = worldX - gp.player.worldX + gp.player.screenX;
      int screenY = worldY - gp.player.worldY + gp.player.screenY;

      // renders only the tiles that need to be seen
      if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX
          && worldX - gp.tileSize < gp.player.worldX + gp.player.screenX
          && worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
          && worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
        g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
      }

      worldCol++;

      if (worldCol == gp.maxWorldCol) {
        worldCol = 0;
        worldRow++;
      }
    }
  }

}
