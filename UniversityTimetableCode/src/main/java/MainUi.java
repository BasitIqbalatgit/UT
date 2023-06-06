import javax.swing.*;

public class MainUi extends JFrame{
    private JButton administrationButton;
    private JButton logoutButton;
    private JButton viewSlotsButton;
    private JButton viewTimetableButton;
    private JButton modifyTimetableButton;
    private JButton generateTimetableButton;
    private JButton allocateCoursesButton;
    public MainUi(){
        setTitle("University Timetable");
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
}
static class Test{
        public static void main(String[] args){
            new MainUi();
        }

}
    }

