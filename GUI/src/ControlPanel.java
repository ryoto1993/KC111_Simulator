import com.sun.tools.javac.tree.JCTree;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by RyotoTomioka on 2016/06/01.
 */
public class ControlPanel extends JPanel implements ActionListener, ChangeListener{

    public ControlPanel() {
        this.setLayout(new GridLayout(5, 1));

        // 照明表示/非表示切り替え
        JCheckBox ck_showLight = new JCheckBox("照明");
        ck_showLight.setActionCommand("showLight");
        ck_showLight.addActionListener(this);
        ck_showLight.setSelected(true);
        this.add(ck_showLight);

        // 点灯パターン表示/非表示切り替え
        JCheckBox ck_showPattern = new JCheckBox("照明点灯パターン");
        ck_showPattern.setActionCommand("showPattern");
        ck_showPattern.addActionListener(this);
        ck_showPattern.setSelected(true);
        this.add(ck_showPattern);

        // 照明点灯光度による色の切り替え
        JCheckBox ck_changeColor = new JCheckBox("照明点灯光度による色の切り替え");
        ck_changeColor.setActionCommand("changeColor");
        ck_changeColor.addActionListener(this);
        ck_changeColor.setSelected(false);
        this.add(ck_changeColor);

        // ステップの切り替え
        JSlider sl_step = new JSlider(0, 1000, 0);
        sl_step.addChangeListener(this);
        this.add(sl_step);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("showLight")) {
            JCheckBox tmp = (JCheckBox) e.getSource();
            if(tmp.isSelected()) {
                SimulationController.setLightLayoutVisible(true);
            } else {
                SimulationController.setLightLayoutVisible(false);
            }
        } else if(e.getActionCommand().equals("showPattern")) {
            JCheckBox tmp = (JCheckBox) e.getSource();
            if(tmp.isSelected()) {
                SimulationController.setLightPatternVisible(true);
            } else {
                SimulationController.setLightPatternVisible(false);
            }
        } else if(e.getActionCommand().equals("changeColor")) {
            JCheckBox tmp = (JCheckBox) e.getSource();
            SimulationController.lightColorChangeMode = tmp.isSelected();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider sl = (JSlider)e.getSource();
        SimulationController.setStep(sl.getValue());
        SimulationController.updateCanvas();
    }
}
