import javax.swing.*;
import java.awt.*;

/**
 * Created by RyotoTomioka on 2016/05/26.
 */
public class MainFrame extends JFrame {
    MainFrame() {
        super();
        this.setTitle("KC111シミュレータ");
        this.setSize(new Dimension(800, 700));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        this.getContentPane().add(new LayoutPane(new Dimension(800, 600)), BorderLayout.CENTER);

        this.setVisible(true);
    }
}
