import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Animation implements ActionListener {
    private boolean keyPressed;
    private BufferedImage[][] frames;
    private Timer timer;
    private int currentFrame;
    private int currentDirection;
    public Animation(BufferedImage[][] frames, int delay, boolean keyPressed) {
        this.frames = frames;
        currentDirection = 0;
        currentFrame = 0;
        timer = new Timer(delay, this);
        timer.start();
        this.keyPressed = keyPressed;
    }
    public void setKeyPressed(boolean press) {
        keyPressed = press;
    }
    public void setCurrentDirection(int set) {
        if (set != currentDirection) {
            currentDirection = set;
            currentFrame = 0;
        }
    }
    public BufferedImage getActiveFrame() {
        return frames[currentDirection][currentFrame];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer && keyPressed) {
            currentFrame = (currentFrame + 1) % frames[0].length;
        }
    }
}
