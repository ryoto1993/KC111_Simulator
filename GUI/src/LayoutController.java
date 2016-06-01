import javax.swing.*;

/**
 * Created by RyotoTomioka on 2016/06/01.
 */
public class LayoutController {
    private static LayoutPane pane;

    public LayoutController() {

    }

    public static void setLatoutPane(LayoutPane pane) {
        LayoutController.pane = pane;
    }

    public static void setLightLayoutVisible(boolean visible) {
        if(visible) {
            pane.add(pane.light_layout, 10);
        } else {
            pane.remove(pane.light_layout);
        }
        pane.repaint();
    }

    public static void setSensorLayoutVisible(boolean visible) {
        if(visible) {
            pane.add(pane.sensor_layout, 20);
        } else {
            pane.remove(pane.sensor_layout);
        }
        pane.repaint();
    }
}
