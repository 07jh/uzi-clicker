import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frame extends JFrame {

    public static int count;
    public static int countadd;
    
    public static void createFrame() {

        count = 0;
        countadd = 1;

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setBounds(100, 100, 600, 600);
        mainFrame.setResizable(false);
        mainFrame.setTitle("" + count);

        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setSize(600, 600);
        ImageIcon backgroundIcon = new ImageIcon("uzibackground.png");
        backgroundLabel.setIcon(backgroundIcon);
        mainFrame.add(backgroundLabel);

        JLabel mainLabel = new JLabel();
        ImageIcon mainImageIcon = new ImageIcon("uzi.png");
        mainLabel.setIcon(mainImageIcon);
        mainLabel.setBounds(200, 200, 200, 200);
        backgroundLabel.add(mainLabel);

        JLabel rightLabel = new JLabel();
        ImageIcon rightImageIcon = new ImageIcon("upgrade.png");
        rightLabel.setIcon(rightImageIcon);
        rightLabel.setBounds(500, 0, 180, 180);
        backgroundLabel.add(rightLabel);
        mainFrame.setVisible(true);

        rightLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                rightLabel.setBounds(420, 0, 180, 180);
                mainFrame.setTitle("+1 per click/cost 100 clicks | " + count);
            }
            public void mouseExited(MouseEvent e) {
                rightLabel.setBounds(500, 0, 180, 180);
                mainFrame.setTitle("" + count);
            }
            public void mouseClicked(MouseEvent e) {
                if(count >= 100) {
                    countadd++;
                    count -= 100;
                    mainFrame.setTitle("Your clicks are now " + countadd + " worth | " + count);
                }
            }
        });

        mainLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                mainLabel.setBounds(200, 180, 200, 200);
            }
            public void mouseExited(MouseEvent e) {
                mainLabel.setBounds(200, 200, 200, 200);

            }
            public void mouseClicked(MouseEvent e) {
                count += countadd;
                mainFrame.setTitle("" + count);
            }
        });
    }
}
