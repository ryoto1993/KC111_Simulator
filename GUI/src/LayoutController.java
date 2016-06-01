import javax.swing.*;

/**
 * Created by RyotoTomioka on 2016/06/01.
 */
public class LayoutController {
    private static LayoutPane pane;
    private static KC111Canvas canvas;

    public LayoutController() {

    }

    public static void setLayoutPane(LayoutPane p) {
        pane = p;
    }

    public static void setCanvas(KC111Canvas c) {
        canvas = c;
    }

    public static void setLightLayoutVisible(boolean visible) {
        if(visible) {
            pane.add(pane.light_layout, 10);
        } else {
            pane.remove(pane.light_layout);
        }
        pane.repaint();
    }

    public static void setLightPatternVisible(boolean visible) {
        if(visible) {
            pane.add(pane.light_pattern, 100);
        } else {
            pane.remove(pane.light_pattern);
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
