import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by RyotoTomioka on 2016/06/01.
 */
public class ControlPanel extends JPanel implements ActionListener{

    public ControlPanel() {
        this.setLayout(new GridLayout(5, 1));

        // 照明表示/非表示切り替え
        JCheckBox ck_showLight = new JCheckBox("照明を表示");
        ck_showLight.setActionCommand("showLight");
        ck_showLight.addActionListener(this);
        ck_showLight.setSelected(true);
        this.add(ck_showLight);

        // 点灯パターン表示/非表示切り替え
        JCheckBox ck_showPattern = new JCheckBox("照明点灯パターンを表示");
        ck_showPattern.setActionCommand("showPattern");
        ck_showPattern.addActionListener(this);
        ck_showPattern.setSelected(true);
        this.add(ck_showPattern);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("showLight")) {
            JCheckBox tmp = (JCheckBox) e.getSource();
            if(tmp.isSelected()) {
                LayoutController.setLightLayoutVisible(true);
            } else {
                LayoutController.setLightLayoutVisible(false);
            }
        }
        else if(e.getActionCommand().equals("showPattern")) {
            JCheckBox tmp = (JCheckBox) e.getSource();
            if(tmp.isSelected()) {
                LayoutController.setLightPatternVisible(true);
            } else {
                LayoutController.setLightPatternVisible(false);
            }
        }
    }
}
