import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tile {
    private boolean collide;
    private BufferedImage tile;
    private int xCoord;
    private int yCoord;
    Tile(boolean collide, String nameTile, int xCoord, int yCoord) {
        this.collide = collide;
        try {
            tile = ImageIO.read(new File(nameTile));
        } catch (IOException e) {
        }
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }
    public BufferedImage getTile() {
        return tile;
    }
    public int getXCoord() {
        return xCoord;
    }
    public int getYCoord() {
        return yCoord;
    }
    public boolean getCollide() {
        return collide;
    }
    public Rectangle TileRect() {
        int imageHeight = getTile().getHeight();
        int imageWidth = getTile().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }

}
