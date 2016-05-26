import javax.swing.*;
import java.awt.*;

/**
 * Created by RyotoTomioka on 2016/05/26.
 */
public class MainFrame extends JFrame {
    MainFrame() {
        super();
        this.setTitle("KC111シミュレータ");
        this.setSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setContentPane(new LayoutPane(getSize()));

        this.setVisible(true);
    }
}
