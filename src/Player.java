import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private double moveAmount;
    private BufferedImage image;

    public Player(String imageName) {
        moveAmount = 5;
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
        Rectangle rect = new Rectangle(300, 295, imageWidth, imageHeight);
        return rect;
    }

    public void moveRight() {
        GraphicsPanel.changeWorldX(-moveAmount);

    }

    public void moveLeft() {
        GraphicsPanel.changeWorldX(moveAmount);

    }

    public void moveUp() {
        GraphicsPanel.changeWorldY(moveAmount);
    }

    public void moveDown() {
        GraphicsPanel.changeWorldY(-moveAmount);
    }


    public boolean isColliding(Tile[][] tileMap) {
        return false;
        }
    }


