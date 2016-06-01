import javax.swing.*;
import org.apache.batik.swing.*;

import java.awt.*;

/**
 * Created by RyotoTomioka on 2016/05/26.
 */
public class LayoutPane extends JLayeredPane{
    public JPanel light_layout, sensor_layout;
    public KC111Canvas light_pattern;
    private JSVGCanvas room_layout;

    private static int ROOM_WIDTH = 604, ROOM_HEIGHT = 562;

    LayoutPane(Dimension parent_dimension) {
        LayoutController.setLayoutPane(this);

        this.setPreferredSize(parent_dimension);
        this.setSize(parent_dimension);
        this.setLayout(null);

        setLight_layout();
        setRoom_layout();
        setSensor_layout();
        setLight_Pattern();

        LayoutController.setLightLayoutVisible(true);
        LayoutController.setSensorLayoutVisible(true);
        LayoutController.setLightPatternVisible(true);
        setRoomLayoutVisible(true);
    }

    public void setRoom_layout() {
        room_layout = new JSVGCanvas();
        room_layout.setURI("GUI/svg/KC111_Ceiling.svg");
        room_layout.setBounds(getWidth()/2-(ROOM_WIDTH /2), (getHeight()-30)/2-(ROOM_HEIGHT /2), ROOM_WIDTH, ROOM_HEIGHT);
        room_layout.setOpaque(false);
        room_layout.setBackground(null);
    }

    public void setLight_layout() {
        light_layout = new JPanel();
        light_layout.setOpaque(false);
        light_layout.setBounds(2+getWidth()/2-(ROOM_WIDTH /2), 6+(getHeight()-30)/2-(ROOM_HEIGHT /2), ROOM_WIDTH -4, ROOM_HEIGHT -12);
        light_layout.setLayout(null);

        JSVGCanvas lightCanvas[] = new JSVGCanvas[12];
        for(int i = 0; i<12; i++) {
            lightCanvas[i] = new JSVGCanvas();
            lightCanvas[i].setURI("GUI/svg/light.svg");
            lightCanvas[i].setBounds(50+(i/3)*150, 100+(i%3)*150, 50, 50);
            light_layout.add(lightCanvas[i]);
        }
    }

    public void setSensor_layout() {
        sensor_layout = new JPanel();
        sensor_layout.setOpaque(false);
        sensor_layout.setBounds(2+getWidth()/2-(ROOM_WIDTH /2), 6+(getHeight()-30)/2-(ROOM_HEIGHT /2), ROOM_WIDTH -4, ROOM_HEIGHT -12);
        sensor_layout.setLayout(null);
    }

    public void setLight_Pattern() {
        light_pattern = new KC111Canvas();
        light_pattern.setBounds(2+getWidth()/2-(ROOM_WIDTH /2), 6+(getHeight()-30)/2-(ROOM_HEIGHT /2), ROOM_WIDTH -4, ROOM_HEIGHT -12);
        light_pattern.setOpaque(false);

    }

    public void setRoomLayoutVisible(boolean visible) {
        if(visible) {
            this.add(room_layout, JLayeredPane.FRAME_CONTENT_LAYER);
        } else {
            this.remove(room_layout);
        }
    }
}
