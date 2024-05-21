import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener{
    private TileMap mainMap;
    private Player player;
    private boolean[] pressedKeys;
    private int y;
    public GraphicsPanel(String name) {
        mainMap = new TileMap();
        player = new Player("src/player.png");
        y = 0;
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
                g.drawImage(mainMap.getMap()[r][c].getTile(), mainMap.getMap()[r][c].getXCoord(), mainMap.getMap()[r][c].getYCoord(), null);
            }
        }
        g.drawImage(player.getImage(), player.getXCoord(), player.getYCoord(), null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (pressedKeys[65]) {
            player.moveLeft(mainMap.getMap());
        }
        if (pressedKeys[68]) {
            player.moveRight(mainMap.getMap());
        }
        if (pressedKeys[87]) {
            player.moveUp(mainMap.getMap());
        }
        if (pressedKeys[83]) {
            player.moveDown(mainMap.getMap());
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
