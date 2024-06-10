import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener{
    private static int worldY = 150;
    private static int worldX = -15;
    private TileMap mainMap;
    private Tile[][] currentMap;
    private Tile[] currentObjects;
    private boolean[][] currentFunctions;
    private Player player;
    private ArrayList<Star> currentStarList;
    private ArrayList<Star> starList1;
    private Star currentStar;
    private int currentStarNum;
    private boolean[] pressedKeys;
    private boolean enemyFight;
    private int enemyKilled;
    // for welcome menu
    private boolean startMenu;
    private JTextField enterName;
    private JButton startButton;
    private BufferedImage menuBackground;
    private BufferedImage elevatorBackground;
    private BufferedImage win;
    private String playerName;
    private boolean elevator;
    private Timer timer;

    public GraphicsPanel(String name) {
        elevator = false;
        startMenu = false;
        mainMap = new TileMap();
        currentMap = mainMap.getMap();
        currentObjects = mainMap.getObject();
        currentFunctions = mainMap.getFunction();
        player = new Player();
        currentStarList = new ArrayList<>();
        starList1 = new ArrayList<>();
        currentStarList.add(new Star(590, 440, new fightMap("src/images/menu.png", "src/images/enemy1.png", "AP Calculus: Double Integrals", 10)));
        currentStarList.add(new Star(270, 440, new fightMap("src/images/menu.png", "src/images/enemy2.png", "AP World History: Magical Continents", 10)));
        starList1.add(new Star(302, 568, new fightMap("src/images/menu.png", "src/images/enemy3.png", "AP Biology: Flask of Germs", 10)));
        starList1.add(new Star(176, 160, new fightMap("src/images/menu.png", "src/images/enemy4.png", "College Board", 20)));
        currentStar = null;
        currentStarNum = -1;
        enemyFight = false;
        enemyKilled = 0;
        pressedKeys = new boolean[128];
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
        startMenu = true;
        enterName = new JTextField("Enter Name",20);
        startButton = new JButton("Start Adventure");
        startButton.addActionListener(this);
        add(enterName);
        add(startButton);
        try {
            menuBackground = ImageIO.read(new File("src/images/welcome/background.png"));
            elevatorBackground = ImageIO.read(new File("src/images/elevatorBackground.png"));
            win = ImageIO.read(new File("src/images/win.png"));
        } catch (IOException e) {
        }
        playerName = "";
        timer = new Timer(100, this);
        timer.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (startMenu) {
            g.drawImage(menuBackground, 0, 0, null);
            startButton.setBackground(new Color(171, 182, 213));
            startButton.setForeground(new Color(34, 42, 63));
            startButton.setBounds(227, 400, 150, 40);
            startButton.setFont(new Font("Kanit", Font.BOLD, 15));
            enterName.setBounds(227, 350, 150, 20);
        } else {
            if (elevator) {
                g.drawImage(elevatorBackground, 0, 0, null);
            } else {
                g.setColor(Color.black);
                g.fillRect(0, 0, 640, 640);
                for (int i = 0; i < currentStarList.size(); i++) {
                    if (currentStarList.get(i).intersectPlayer(player)) {
                        currentStar = currentStarList.get(i);
                        currentStarNum = i;
                        enemyFight = true;
                    }
                }
                if (!enemyFight) {
                    for (int r = 0; r < currentMap.length; r++) {
                        for (int c = 0; c < currentMap[r].length; c++) {
                            g.drawImage(currentMap[r][c].getTile(), currentMap[r][c].getXCoord() + worldX, currentMap[r][c].getYCoord() + worldY, null);
                        }
                    }
                    for (int i = 0; i < currentObjects.length; i++) {
                        g.drawImage(currentObjects[i].getTile(), currentObjects[i].getXCoord() + worldX, currentObjects[i].getYCoord() + worldY, null);
                    }
                    for (int i = 0; i < currentStarList.size(); i++) {
                        g.drawImage(currentStarList.get(i).getImage(), currentStarList.get(i).getXCoord() + worldX, currentStarList.get(i).getYCoord() + worldY, null);
                    }
                    g.setColor(Color.WHITE);
                    g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
                    g.drawString("CLASSES BEATEN: " + enemyKilled + "/4", 5, 50);
                    g.drawString(playerName, 5, 25);
                    g.drawImage(player.getImage(), 300, 295, null);
                }
                if (enemyFight) {
                    g.drawImage(currentStar.getFight().getEnemy(), 340, 20, null);
                    g.setColor(Color.white);
                    g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
                    g.drawString("ENEMY STATS", 30, 50);
                    g.drawString(currentStar.getFight().getEnemyName(), 30, 80);
                    g.drawString(currentStar.getFight().getEnemyHealth() + "", 30, 110);
                    g.drawImage(currentStar.getFight().getMenu(), 15, 285, null);
                    if (currentStar.getFight().getEnemyHealth() <= 0) {
                        changeWorldX(10);
                        changeWorldY(10);
                        currentStarList.remove(currentStarNum);
                        enemyKilled++;
                        enemyFight = false;
                        if (enemyKilled == 3) {
                            mainMap.finalBoss();
                        }
                    }
                }
            }
        } if (enemyKilled == 4) {
            g.drawImage(win, 0, 0, null);

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
        if (e.getSource() instanceof JButton) {
            playerName = enterName.getText();
            startMenu = false;
            startButton.hide();
            enterName.hide();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (!enemyFight) {
            String collide = player.isColliding(currentMap, currentFunctions);
            if (collide.contains("elevator") && enemyKilled == 2) {
                elevator = true;
                currentMap = mainMap.getMap1();
                currentObjects = mainMap.getObject1();
                currentFunctions = mainMap.getFunction1();
                currentStarList = starList1;
                worldX = 130;
                worldY = -435;
            }
            if (pressedKeys[65] && !collide.contains("left")) {
                player.moveLeft();
            }
            if (pressedKeys[68] && !collide.contains("right")) {
                player.moveRight();
            }
            if (pressedKeys[87] && !collide.contains("up")) {
                player.moveUp();
            }
            if (pressedKeys[83] && !collide.contains("down")) {
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
        if (enemyFight) {
            if ((currentStar.getFight().getAttack().contains(getMousePosition()))) {
                currentStar.getFight().reduceHealth();
            } else if (currentStar.getFight().getQuit().contains(getMousePosition())) {
                changeWorldX(10);
                changeWorldY(10);
                enemyFight = false;
            }
        }
        if (elevator) {
            elevator = false;
        }
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
