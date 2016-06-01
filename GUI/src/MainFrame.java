import javax.swing.*;
import java.awt.*;

/**
 * Created by RyotoTomioka on 2016/05/26.
 */
public class MainFrame extends JFrame {
    LayoutPane layoutPane;

    MainFrame() {
        super();
        this.setTitle("KC111シミュレータ");
        this.setSize(new Dimension(800, 700));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());

        layoutPane = new LayoutPane(new Dimension(800, 600));
        this.getContentPane().add(layoutPane, BorderLayout.CENTER);
        this.getContentPane().add(new ControlPanel(), BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
