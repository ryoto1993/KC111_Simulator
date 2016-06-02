import javax.swing.*;

import javafx.scene.layout.Background;
import org.apache.batik.swing.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by RyotoTomioka on 2016/05/26.
 */
public class LayoutPane extends JLayeredPane{
    public JPanel light_layout, sensor_layout;
    public KC111Canvas light_pattern;
    private JSVGCanvas room_layout;

    private static int ROOM_WIDTH = 604, ROOM_HEIGHT = 562;

    LayoutPane(Dimension parent_dimension) {
        SimulationController.setLayoutPane(this);

        this.setPreferredSize(parent_dimension);
        this.setSize(parent_dimension);

        SimulationController.setLight();
        SimulationController.setLightHistory();

        setLight_layout();
        setRoom_layout();
        setSensor_layout();
        setLight_Pattern();

        SimulationController.setLightPatternVisible(true);
        SimulationController.setSensorLayoutVisible(true);
        SimulationController.setLightLayoutVisible(true);
        setRoomLayoutVisible(true);
    }

    public void setRoom_layout() {
        room_layout = new JSVGCanvas();
        room_layout.setURI("svg/KC111_Ceiling.svg");
        room_layout.setBounds(getWidth()/2-(ROOM_WIDTH /2), (getHeight()-30)/2-(ROOM_HEIGHT /2), ROOM_WIDTH, ROOM_HEIGHT);
        room_layout.setOpaque(false);
        room_layout.setBackground(null);
    }

    public void setLight_layout() {
        light_layout = new JPanel();
        light_layout.setOpaque(false);
        light_layout.setBounds(2+getWidth()/2-(ROOM_WIDTH /2), 6+(getHeight()-30)/2-(ROOM_HEIGHT /2), ROOM_WIDTH -4, ROOM_HEIGHT -12);
        light_layout.setLayout(null);

        ArrayList<Light> lights = SimulationController.lights;
        JSVGCanvas lightCanvas[] = new JSVGCanvas[lights.size()];
        for(int i = 0; i<lights.size(); i++) {
            lightCanvas[i] = new JSVGCanvas();
            lightCanvas[i].setURI("svg/light.svg");
            lightCanvas[i].setBounds((lights.get(i).getX()-1)*50, (lights.get(i).getY()-1)*50, 50, 50);
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
