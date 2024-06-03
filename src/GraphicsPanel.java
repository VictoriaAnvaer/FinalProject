import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener{
    private TileMap mainMap;
    private Player player;
    private Star star;
    private fightMap fight;
    private boolean[] pressedKeys;
    private boolean enemyFight;
    private static int worldY = 0;
    private static int worldX = 0;
    public GraphicsPanel(String name) {
        mainMap = new TileMap();
        player = new Player();
        star = new Star(32, 112);
        fight = null;
        pressedKeys = new boolean[128];
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 640, 640);
        enemyFight = star.intersectPlayer(player);
        if (!enemyFight) {
            for (int r = 0; r < mainMap.getMap().length; r++) {
                for (int c = 0; c < mainMap.getMap()[r].length; c++) {
                    g.drawImage(mainMap.getMap()[r][c].getTile(), mainMap.getMap()[r][c].getXCoord() + worldX, mainMap.getMap()[r][c].getYCoord() + worldY, null);
                }
            }
            g.drawImage(star.getImage(), star.getXCoord() + worldX, star.getYCoord() + worldY, null);
            g.drawImage(player.getImage(), 300, 295, null);
        }
        if (enemyFight) {
            fight = new fightMap("src/images/placeholderMenu.png", "src/images/enemy1.png", "placeholder", 100);
            g.drawImage(fight.getEnemy(), 400, 100, null);
            g.setColor(Color.white);
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
            g.drawString("ENEMY STATS", 30, 50);
            g.drawString(fight.getEnemyName(), 30, 80);
            g.drawString(fight.getEnemyHealth() + "", 30, 110);
            g.drawImage(fight.getMenu(), 20, 350, null);


        }
    }
    public static void changeWorldX(double change) {
        worldX+=(int) change;
    }
    public static void changeWorldY(double change) {
        worldY+=(int) change;
    }
    public static int getWorldX() {
        return worldX;
    }
    public static int getWorldY() {
        return worldY;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!enemyFight) {
            String collide = player.isCollidingWIP(mainMap.getMap());
            if (pressedKeys[65] && !collide.equals("left")) {
                player.moveLeft();
            }
            if (pressedKeys[68] && !collide.equals("right")) {
                player.moveRight();
            }
            if (pressedKeys[87] && !collide.equals("up")) {
                player.moveUp();
            }
            if (pressedKeys[83] && !collide.equals("down")) {
                player.moveDown();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        player.setKeyPressAnimation(true);
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        player.setKeyPressAnimation(false);
        int key = e.getKeyCode();
        pressedKeys[key] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
