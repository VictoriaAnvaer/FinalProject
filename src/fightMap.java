import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class fightMap {
    private BufferedImage menu;
    private BufferedImage enemy;
    private String enemyName;
    private int enemyHealth;

    fightMap(String menuFile, String enemyFile, String enemyName, int enemyHealth) {
        try {
            enemy = ImageIO.read(new File(enemyFile));
            menu = ImageIO.read(new File(menuFile));
        } catch (IOException e) {
        }
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
    }
    public BufferedImage getMenu() {
        return menu;
    }
    public Rectangle getAttack() {
        Rectangle rect = new Rectangle(38, 403, 212, 65);
        return rect;

    }
    public Rectangle getQuit() {
        Rectangle rect = new Rectangle(348, 403, 212, 65);
        return rect;

    }
    public void reduceHealth() {
        enemyHealth--;
    }
    public BufferedImage getEnemy() {
        return enemy;
    }
    public String getEnemyName() {
        return enemyName;
    }
    public int getEnemyHealth() {
        return enemyHealth;
    }
}
