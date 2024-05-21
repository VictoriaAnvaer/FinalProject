import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private double moveAmount;
    private BufferedImage image;
    private double xCoord;
    private double yCoord;

    public Player(String imageName) {
        moveAmount = 4;
        xCoord = 50;
        yCoord = 50;
        try {
            image = ImageIO.read(new File(imageName));
        } catch (IOException e) {
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public Rectangle playerRect() {
        int imageHeight = getImage().getHeight();
        int imageWidth = getImage().getWidth();
        Rectangle rect = new Rectangle((int) xCoord, (int) yCoord, imageWidth, imageHeight);
        return rect;
    }

    public void moveRight(Tile[][] tileMap) {
        if (isColliding(tileMap)) {
            xCoord += moveAmount;
        } else {
            xCoord-=moveAmount * 2;
        }

    }

    public void moveLeft(Tile[][] tileMap) {
        if (isColliding(tileMap)) {
            xCoord -= moveAmount;
        } else {
            xCoord+= moveAmount * 2;
        }

    }

    public void moveUp(Tile[][] tileMap) {
        if (isColliding(tileMap)) {
            yCoord -= moveAmount;
        } else {
            yCoord += moveAmount * 2;
        }
    }

    public void moveDown(Tile[][] tileMap) {
        if (isColliding(tileMap)) {
            yCoord += moveAmount;
        } else {
            yCoord -= moveAmount * 2;
        }
    }

    public int getYCoord() {
        return (int) yCoord;
    }

    public int getXCoord() {
        return (int) xCoord;
    }

    public boolean isColliding(Tile[][] tileMap) {
        for (Tile[] r : tileMap) {
            for (Tile t : r) {
                if (t.getCollide() && playerRect().intersects(t.TileRect())) {
                    return false;
                }
                }
            }
        return true;
        }
    }


