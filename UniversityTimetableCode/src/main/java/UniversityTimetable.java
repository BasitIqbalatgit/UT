import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UniversityTimetable extends JFrame {

    private JPanel leftPanel;
    private JButton[] buttons;

    public UniversityTimetable() {
        super("University Timetable");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the panel on the left side of the frame
        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, getHeight()));
        leftPanel.setBackground(Color.LIGHT_GRAY);

        // Create the six buttons
        buttons = new JButton[6];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Button " + (i + 1));
            buttons[i].setPreferredSize(new Dimension(leftPanel.getWidth(), 50));
            buttons[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    ((JButton) e.getSource()).setBackground(Color.GREEN);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    ((JButton) e.getSource()).setBackground(UIManager.getColor("control"));
                }
            });
        }

        // Add the six buttons to the left panel
        for (int i = 0; i < buttons.length; i++) {
            leftPanel.add(buttons[i]);
        }

        // Add the left panel to the frame
        add(leftPanel, BorderLayout.WEST);

        // Position the frame in the center of the screen
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {
        new UniversityTimetable();
    }

}
