import javax.swing.*;

public class InfoGUI {
    public ImageIcon icon = new ImageIcon("res/icon.png");

    public JFrame infoFrame = new JFrame("Calculator - App Updates & Info");

    public void open() {
        infoFrame.pack();
        infoFrame.setIconImage(icon.getImage());
        infoFrame.setLayout(null);
        infoFrame.setSize(600, 250);
        infoFrame.setResizable(false);
        infoFrame.setLocationRelativeTo(null);
        infoFrame.setVisible(true);
        infoFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        setupGUI();
    }

    public void setupGUI() {
        JLabel info = new JLabel();
        info.setText("<html>Thanks for downloading and using my simple calculator made in <span style='color: blue'>java</span>, using <span style='color: blue'>swing</span> library!<br>If you have any questions, you can visit my github page (<span style='color: red'>AdamGamesStudio</span> / <span style='color: gray'>java-calculator</span>),<br>or e-mail me at <span style='color: red'>adam.duda@post.com</span>. All of our projects are hobbyist (for now),<br>and available on our github (look above). We recommend to try other of our products. This is one of the first versions of this app, and in the future, we are planning to add more functions. If you will spot any bugs or errors, please contact me. Have a nice experience!</html>");
        info.setBounds(5, -25,600, 250);

        JLabel version = new JLabel();
        version.setText("<html>Version <span style='color: gray'>0.21</span>. To get newer versions, check our <span style='color: gray'>github.</span></html>");
        version.setBounds(5, 190,500, 20);

        infoFrame.add(version);
        infoFrame.add(info);
    }
}
