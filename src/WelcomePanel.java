import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class WelcomePanel extends JPanel implements KeyListener, MouseListener, ActionListener{
    private JTextField enterName;
    private JButton startButton;

    WelcomePanel(String name) {
        enterName = new JTextField(20);
        startButton = new JButton("Start Adventure");
        add(enterName);
        add(startButton);
        startButton.addActionListener(this);
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        startButton.setLocation(100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

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
