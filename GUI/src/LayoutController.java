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
            pane.add(pane.light_layout, JLayeredPane.DEFAULT_LAYER);
        } else {
            pane.remove(pane.light_layout);
        }
    }

    public static void setSensorLayoutVisible(boolean visible) {
        if(visible) {
            pane.add(pane.sensor_layout, JLayeredPane.DEFAULT_LAYER);
        } else {
            pane.remove(pane.sensor_layout);
        }
    }
}
