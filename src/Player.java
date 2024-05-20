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
        moveAmount = 1.5;
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
    public void moveRight() {
        xCoord+=moveAmount;

    }
    public void moveLeft() {
        xCoord-=moveAmount;

    }
    public void moveUp() {
        yCoord-=moveAmount;

    }
    public void moveDown() {
        yCoord+=moveAmount;

    }

    public int getYCoord() {
        return (int) yCoord;
    }
    public int getXCoord() {
        return (int) xCoord;
    }
}
