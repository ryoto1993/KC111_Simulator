import javax.swing.*;
import java.awt.*;

/**
 * Created by RyotoTomioka on 2016/06/01.
 */
public class KC111Canvas extends JPanel {
    public KC111Canvas() {
        LayoutController.setCanvas(this);
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(255, 146, 0, 193));
        g.fillRect(0, 0, 50, 50);
    }
}
