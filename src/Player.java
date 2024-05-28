import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private double moveAmount;
    private Animation run;

    public Player() {
        moveAmount = 5;
        BufferedImage[][] runAnimation = new BufferedImage[4][3];
        for (int r = 0; r < runAnimation.length; r++) {
            for (int c = 0; c < runAnimation[0].length; c++) {
                String filename = "src/images/player/" + r + c + ".png";
                try {
                    runAnimation[r][c] = (ImageIO.read(new File(filename)));
                } catch (IOException e) {
                }
            }
        }
        run = new Animation(runAnimation, 100);
    }

    public BufferedImage getImage() {
        return run.getActiveFrame();
    }

    public Rectangle playerRect() {
        Rectangle rect = new Rectangle(310, 330, getImage().getWidth() - 20, getImage().getHeight() - 60);
        return rect;
    }

    public void moveRight() {
        run.setCurrentDirection(2);
        GraphicsPanel.changeWorldX(-moveAmount);

    }

    public void moveLeft() {
        run.setCurrentDirection(1);
        GraphicsPanel.changeWorldX(moveAmount);

    }

    public void moveUp() {
        run.setCurrentDirection(3);
        GraphicsPanel.changeWorldY(moveAmount);
    }

    public void moveDown() {
        run.setCurrentDirection(0);
        GraphicsPanel.changeWorldY(-moveAmount);
    }


    public boolean isColliding(Tile[][] tileMap) {
        // world x and world y
        return false;
    }
    }


