import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UniversityTimetable1 extends JFrame {

    private JPanel panel;
    private JButton[] buttons;

    public UniversityTimetable1() {
        super("University Timetable");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the panel and buttons
        panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(200, 500));
        panel.setBackground(Color.getHSBColor(155, 145,190));
        
        buttons = new JButton[6];
        int y = (panel.getHeight() - 20 * buttons.length) / 2;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Button " + (i+1));
            buttons[i].addMouseListener(new ButtonListener(i));
            buttons[i].setBounds(0, y + i*20, panel.getWidth(), 20);
            panel.add(buttons[i]);
        }


        // Add the panel to the left side of the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.WEST);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.getHSBColor(105, 190, 100));
    }

    // Listener for the buttons
    private class ButtonListener extends MouseAdapter {
        private int index;
        private Color[] colors = {Color.LIGHT_GRAY};
        private int colorIndex = 0;

        public ButtonListener(int index) {
            this.index = index;
        }

        public void mouseEntered(MouseEvent e) {
            buttons[index].setBackground(colors[colorIndex]);
            colorIndex = (colorIndex + 1) % colors.length;
        }
    }

    public static void main(String[] args) {
        new UniversityTimetable1();
    }

}
