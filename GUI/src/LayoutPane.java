import javax.swing.*;
import org.apache.batik.swing.*;

import java.awt.*;

/**
 * Created by RyotoTomioka on 2016/05/26.
 */
public class LayoutPane extends JLayeredPane{
    private JPanel light_layout, sensor_layout;
    private JSVGCanvas room_layout;

    LayoutPane(Dimension parent_dimension) {
        this.setPreferredSize(parent_dimension);
        this.setSize(parent_dimension);
        this.setLayout(null);

        setRoom_layout();
        setLight_layout();
        sensor_layout = new JPanel();

        this.add(light_layout, JLayeredPane.DEFAULT_LAYER);
        this.add(room_layout, JLayeredPane.DEFAULT_LAYER);

    }

    public void setRoom_layout() {
        room_layout = new JSVGCanvas();
        room_layout.setURI("GUI/KC111_Ceiling.svg");
        room_layout.setBounds(0,0, getWidth(), getHeight());
    }

    public void setLight_layout() {
        light_layout = new JPanel();
        light_layout.setOpaque(false);
        light_layout.setBounds(0, 0, getWidth(), getHeight());
    }

}
