import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class fightMap {
    BufferedImage menu;
    BufferedImage enemy;
    String enemyName;
    int enemyHealth;
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
    //public Rectangle getAttack() {
//
    //}
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
