import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by RyotoTomioka on 2016/06/01.
 */
public class KC111Canvas extends JPanel {
    public KC111Canvas() {
        SimulationController.setCanvas(this);
    }

    public void paintComponent(Graphics g) {
        ArrayList<Light> lights = SimulationController.lights;
        int max = lights.get(0).MAXLUM;
        int step = SimulationController.getStep();

        g.setColor(new Color(255, 146, 0, 193));

        for(int i = 0; i< lights.size(); i++) {
            int size = 100 * lights.get(i).getLum(step)/max;

            g.fillOval((lights.get(i).getX()-1)*50 + 25 - size/2,
                    (lights.get(i).getY()-1)*50 + 25 - size/2,
                    size,
                    size);
        }
    }
}
