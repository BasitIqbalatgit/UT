import javax.swing.*;
import java.awt.*;

public class TimeTableManagementSystem {
    private JFrame frame;
    private JPanel dashboardPanel;
    private JMenuBar menuBar;

    public TimeTableManagementSystem() {
        frame = new JFrame("Time Table Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Creating the menu bar
        menuBar = new JMenuBar();
        JLabel companyNameLabel = new JLabel("TTMS");
        companyNameLabel.setHorizontalAlignment(JLabel.CENTER);
        companyNameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(companyNameLabel);
        menuBar.add(Box.createHorizontalGlue());

        // Creating the dashboard panel
        dashboardPanel = new JPanel();
        dashboardPanel.setLayout(new BorderLayout());
        JLabel dashboardLabel = new JLabel("Dashboard");
        dashboardLabel.setHorizontalAlignment(JLabel.CENTER);
        dashboardPanel.add(dashboardLabel, BorderLayout.CENTER);

        // Adding components to the frame
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(dashboardPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TimeTableManagementSystem::new);
    }
}
