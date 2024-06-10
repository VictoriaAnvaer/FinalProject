import javax.swing.*;
public class MainFrame implements Runnable {
    private GraphicsPanel panel;
    private JFrame frame;
    public MainFrame(String name) {
        frame = new JFrame("BTHS Adventure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 640);
        frame.setLocationRelativeTo(null);
        panel = new GraphicsPanel(name);
        frame.add(panel);
        frame.setVisible(true);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            panel.repaint();
        }

    }
}
