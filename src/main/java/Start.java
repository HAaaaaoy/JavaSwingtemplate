import javax.swing.*;

public class Start {
    public static void main(String[] args) {
        DataBox dataBox = new DataBox();
        dataBox.load();
        JPanel panel = dataBox.getPanel();
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(panel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
