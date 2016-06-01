import javax.swing.*;
import org.apache.batik.swing.*;

import java.awt.*;

/**
 * Created by RyotoTomioka on 2016/05/26.
 */
public class LayoutPane extends JLayeredPane{
    private JPanel light_layout, sensor_layout;
    private JSVGCanvas room_layout;

    private int room_width = 604, room_height = 562;

    LayoutPane(Dimension parent_dimension) {
        this.setPreferredSize(parent_dimension);
        this.setSize(parent_dimension);
        this.setLayout(null);

        setRoom_layout();
        setLight_layout();
        setSensor_layout();

        setLightLayoutVisible(true);
        setSensorLayoutVisible(true);
        setRoomLayoutVisible(true);
    }

    public void setRoom_layout() {
        room_layout = new JSVGCanvas();
        room_layout.setURI("GUI/svg/KC111_Ceiling.svg");
        room_layout.setBounds(getWidth()/2-(room_width/2), (getHeight()-20)/2-(room_height/2), room_width, room_height);
        room_layout.setOpaque(false);
        room_layout.setBackground(null);
    }

    public void setLight_layout() {
        light_layout = new JPanel();
        light_layout.setOpaque(false);
        light_layout.setBounds(2+getWidth()/2-(room_width/2), 6+(getHeight()-20)/2-(room_height/2), room_width-2, room_height-6);
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
        sensor_layout.setBounds(2+getWidth()/2-(room_width/2), 6+(getHeight()-20)/2-(room_height/2), room_width-2, room_height-6);
        sensor_layout.setLayout(null);
    }

    public void setRoomLayoutVisible(boolean visible) {
        if(visible) {
            this.add(room_layout, JLayeredPane.DEFAULT_LAYER);
        } else {
            this.remove(room_layout);
        }
    }

    public void setLightLayoutVisible(boolean visible) {
        if(visible) {
            this.add(light_layout, JLayeredPane.DEFAULT_LAYER);
        } else {
            this.remove(light_layout);
        }
    }

    public void setSensorLayoutVisible(boolean visible) {
        if(visible) {
            this.add(sensor_layout, JLayeredPane.DEFAULT_LAYER);
        } else {
            this.remove(sensor_layout);
        }
    }

}
