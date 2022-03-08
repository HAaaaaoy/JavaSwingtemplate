package GUI;

import Guitil.GUItil;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private TopoForm topoForm;
    private DataBox dataBox;
    private NotificationForm notificationForm;
    private ControlPanel controlPanel;
    public MainFrame() {
        this.setLayout(new BorderLayout(3,3));
    }
    public void load() {
        topoForm = new TopoForm();
        dataBox = new DataBox();
        //加载JTree
        dataBox.load();
        notificationForm = new NotificationForm();
        controlPanel = new ControlPanel();
        JPanel panel1 = topoForm.getJpanel();
        JPanel panel2 = dataBox.getPanel();
        JPanel panel3 = notificationForm.getPanel1();
        JPanel panel4 = controlPanel.getPanel();
        this.add(panel1,BorderLayout.CENTER);
        this.add(panel2,BorderLayout.WEST);
        this.add(panel3,BorderLayout.NORTH);
        this.add(panel4,BorderLayout.EAST);
        Rectangle bounds = GUItil.getBounds();
        this.setBounds(bounds);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //窗体可拉伸
        this.setTitle("羊群系统自组网仿真系统");
        this.setResizable(true);
        this.setVisible(true);
    }

}
