import org.apache.batik.swing.JSVGCanvas;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by RyotoTomioka on 2016/06/01.
 */
public class SimulationController {
    private static LayoutPane pane;
    private static KC111Canvas canvas;
    public static ArrayList<Light> lights = new ArrayList<>();
    public static ArrayList<JLabel> luminosity_labels = new ArrayList<>();
    public static ArrayList<JSVGCanvas> light_canbas = new ArrayList<>();
    private static int step = 0;
    public static boolean lightColorChangeMode = false;


    public static void setLight() {
        try {
            File csv = new File("data/light.csv"); // CSVデータファイル
            BufferedReader br = new BufferedReader(new FileReader(csv));

            // 最終行まで読み込む
            String line = "";
            while ((line = br.readLine()) != null) {

                // 1行をデータの要素に分割
                StringTokenizer st = new StringTokenizer(line, ",");

                while (st.hasMoreTokens()) {
                    // 1行の各要素をタブ区切りで表示
                    lights.add(new Light(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                    luminosity_labels.add(new JLabel());

                    JSVGCanvas canvas = new JSVGCanvas();
                    canvas.setURI("svg/light_op.svg");
                    canvas.setBounds((lights.get(lights.size()-1).getX()-1)*50, (lights.get(lights.size()-1).getY()-1)*50, 50, 50);
                    canvas.setBackground(new Color(242, 150, 0));
                    light_canbas.add(canvas);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setLightHistory() {
        try {
            File csv = new File("data/light_history.csv"); // CSVデータファイル
            BufferedReader br = new BufferedReader(new FileReader(csv));

            // 最終行まで読み込む
            String line = "";
            while ((line = br.readLine()) != null) {

                // 1行をデータの要素に分割
                StringTokenizer st = new StringTokenizer(line, ",");

                while (st.hasMoreTokens()) {
                    // 1行の各要素をタブ区切りで表示
                    for(int i=0; i<lights.size(); i++) {
                        lights.get(i).appendHistory(Integer.parseInt(st.nextToken()));
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setLayoutPane(LayoutPane p) {
        pane = p;
    }

    public static void setCanvas(KC111Canvas c) {
        canvas = c;
    }

    public static void setLightLayoutVisible(boolean visible) {
        if(visible) {
            pane.add(pane.light_layout, JLayeredPane.DEFAULT_LAYER);
            pane.setLayer(pane.light_layout, 10);
        } else {
            pane.remove(pane.light_layout);
        }
        pane.repaint();
    }

    public static void setLightPatternVisible(boolean visible) {
        if(visible) {
            pane.add(pane.light_pattern, JLayeredPane.DEFAULT_LAYER);
            pane.setLayer(pane.light_pattern, 100);
        } else {
            pane.remove(pane.light_pattern);
        }
        pane.repaint();
    }

    public static void setLuminosityLabelVisible(boolean visible) {
        if(visible) {
            pane.add(pane.luminosity_layout, JLayeredPane.DEFAULT_LAYER);
            pane.setLayer(pane.luminosity_layout, 110);
        } else {
            pane.remove(pane.luminosity_layout);
        }
        pane.repaint();
    }

    public static void setSensorLayoutVisible(boolean visible) {
        if(visible) {
            pane.add(pane.sensor_layout, JLayeredPane.DEFAULT_LAYER);
            pane.setLayer(pane.sensor_layout, 20);
        } else {
            pane.remove(pane.sensor_layout);
        }
        pane.repaint();
    }

    public static int getStep() {
        return step;
    }

    public static void setStep(int s) {
        step = s;

        if(lightColorChangeMode) {
            for (int i = 0; i < lights.size(); i++) {
                double lum = (double) lights.get(i).getLum(step);
                double max = Light.MAXLUM;
                luminosity_labels.get(i).setText(Integer.toString(lights.get(i).getLum(step)) + " cd");
                int r = (int) (204 + 38 * (lum / max));
                int g = (int) (204 - 54 * (lum / max));
                int b = (int) (204 - 204 * (lum / max));
                light_canbas.get(i).setBackground(new Color(r, g, b));
            }
        } else {
            for (int i=0; i<lights.size(); i++) {
                luminosity_labels.get(i).setText(Integer.toString(lights.get(i).getLum(step)) + " cd");
                light_canbas.get(i).setBackground(new Color(242, 150, 0));
            }
        }
    }

    public static void updateCanvas() {
        canvas.repaint();
    }
}
