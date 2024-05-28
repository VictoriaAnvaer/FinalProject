import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener{
    private TileMap mainMap;
    private Player player;
    private boolean[] pressedKeys;
    private static int worldY = 0;
    private static int worldX = 0;
    public GraphicsPanel(String name) {
        mainMap = new TileMap();
        player = new Player("src/images/player.png");
        pressedKeys = new boolean[128];
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int r = 0; r < mainMap.getMap().length; r++) {
            for (int c = 0; c < mainMap.getMap()[r].length; c++) {
                g.drawImage(mainMap.getMap()[r][c].getTile(), mainMap.getMap()[r][c].getXCoord() + worldX, mainMap.getMap()[r][c].getYCoord() + worldY, null);
            }
        }
        g.drawImage(player.getImage(), 300, 295, null);
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
        if (pressedKeys[65]) {
            player.moveLeft();
        }
        if (pressedKeys[68]) {
            player.moveRight();
        }
        if (pressedKeys[87]) {
            player.moveUp();
        }
        if (pressedKeys[83]) {
            player.moveDown();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
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
