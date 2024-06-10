import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    private double moveAmount;
    private double moveX;
    private double moveY;
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
        run = new Animation(runAnimation, 150, false);
    }

    public BufferedImage getImage() {
        return run.getActiveFrame();
    }

    public Rectangle playerRect() {
        Rectangle rect = new Rectangle(310, 330, getImage().getWidth() - 20, getImage().getHeight() - 50);
        return rect;
    }
    public void setKeyPressAnimation(boolean set) {
        run.setKeyPressed(set);
    }

    public void moveRight() {
        run.setCurrentDirection(2);
        GraphicsPanel.changeWorldX(-moveAmount);
        moveX = -moveAmount;

    }

    public void moveLeft() {
        run.setCurrentDirection(1);
        GraphicsPanel.changeWorldX(moveAmount);
        moveX = moveAmount;

    }

    public void moveUp() {
        run.setCurrentDirection(3);
        GraphicsPanel.changeWorldY(moveAmount);
        moveY = moveAmount;
    }

    public void moveDown() {
        run.setCurrentDirection(0);
        GraphicsPanel.changeWorldY(-moveAmount);
        moveY = -moveAmount;
    }


    public String isColliding(Tile[][] tileMap, boolean[][] functionMap) {
        String elevator = "";
        for (int r = 0; r < tileMap.length; r++) {
            for (int c = 0; c < tileMap[r].length; c++) {
                if (tileMap[r][c].tileRect().intersects(playerRect())) {
                    if (functionMap[r][c]) {
                        elevator = "elevator";
                    }
                    if (tileMap[r][c].getCollide()) {
                        if (moveX < 0) {
                            return "right" + elevator;
                        } else if (moveX > 0) {
                            return "left" + elevator;
                        } else if (moveY < 0) {
                            return "down" + elevator;
                        } else if (moveY > 0) {
                            return "up" + elevator;
                        }
                    }
                }
            }
        }
        moveX = 0;
        moveY = 0;
        return elevator;
    }
}


