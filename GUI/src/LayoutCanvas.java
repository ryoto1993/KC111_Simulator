import javax.swing.*;

/**
 * Created by RyotoTomioka on 2016/05/26.
 */
public class LayoutCanvas extends JLayeredPane{
    private JPanel room_layout, light_layout, sensor_layout;

    LayoutCanvas() {
        room_layout = new JPanel();
        light_layout = new JPanel();
        sensor_layout = new JPanel();

        this.add(room_layout, JLayeredPane.DEFAULT_LAYER);

    }

}
