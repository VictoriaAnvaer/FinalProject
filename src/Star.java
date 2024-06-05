import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Star {
    private Animation animation;
    private int xCoord;
    private int yCoord;
    private fightMap fight;
    Star(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        BufferedImage[][] runAnimation = new BufferedImage[1][4];
        for (int r = 0; r < runAnimation.length; r++) {
            for (int c = 0; c < runAnimation[0].length; c++) {
                String filename = "src/images/star/s" + c + ".png";
                try {
                    runAnimation[r][c] = (ImageIO.read(new File(filename)));
                } catch (IOException e) {
                }
            }
        }
        animation = new Animation(runAnimation, 220, true);
        fight = new fightMap("src/images/menu.png", "src/images/enemy1.png", "placeholder", 100);
    }
    public int getXCoord() {
        return xCoord;
    }
    public int getYCoord() {
        return yCoord;
    }
    public BufferedImage getImage() {
        return animation.getActiveFrame();
    }
    public fightMap getFight() {
        return fight;
    }
    public Rectangle starRect() {
        Rectangle rect = new Rectangle(xCoord + GraphicsPanel.getWorldX(), yCoord + GraphicsPanel.getWorldY(),getImage().getWidth(), getImage().getHeight());
        return rect;
    }
    public boolean intersectPlayer(Player player) {
        if (player.playerRect().intersects(starRect())) {
            return true;
        }
        return false;
    }
}
