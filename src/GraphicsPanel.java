import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener{
    private int[] mapNum;
    private Tile[] map;
    private Player player;
    private boolean[] pressedKeys;
    private int y;
    public GraphicsPanel(String name) {
        player = new Player("src/player.png");
        mapNum = new int[]{1, 0, 0, 0, 0, 0, 0, 1};
        map = new Tile[8];
        y = 0;
        pressedKeys = new boolean[128];
        for (int i = 0; i < mapNum.length; i++) {
            if (mapNum[i] == 1) {
                map[i] = new Tile(false, "src/wall.png", 0, y);
            } else {
                map[i] = new Tile(true, "src/wood.png", 0, y);
            }
            y+=32;
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < map.length; i++) {
            g.drawImage(map[i].getTile(), map[i].getXCoord(), map[i].getYCoord(), null);
        }
        g.drawImage(player.getImage(), player.getXCoord(), player.getYCoord(), null);
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
