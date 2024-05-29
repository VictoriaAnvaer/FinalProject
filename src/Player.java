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
        run = new Animation(runAnimation, 150);
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
        for (int r = 0; r < tileMap.length; r++) {
            for (int c = 0; c < tileMap[r].length; c++) {
                if (tileMap[r][c].getCollide() && tileMap[r][c].tileRect().intersects(playerRect())) {
                    return true;
                }
            }
        }
        return false;
    }
    public String isCollidingWIP(Tile[][] tileMap) {
        for (int r = 0; r < tileMap.length; r++) {
            for (int c = 0; c < tileMap[r].length; c++) {
                if (tileMap[r][c].getCollide() && tileMap[r][c].tileRect().intersects(playerRect())) {
                    System.out.println(tileMap[r][c].tileRect().x + " " + tileMap[r][c].tileRect().y);
                    if (tileMap[r][c].tileRect().contains(310, 330, 1, 40)) {
                        System.out.println("left");
                        return "left";
                    } else if (tileMap[r][c].tileRect().contains(310, 330, 28, 1)) {
                        System.out.println("up");
                        return "up";
                    } else if (tileMap[r][c].tileRect().contains(338, 330, 1, 40)) {
                        System.out.println("right");
                        return "right";
                    } else {
                        System.out.println("down");
                        return "down";
                    }
                }
            }
        }
        return " ";

    }
}


