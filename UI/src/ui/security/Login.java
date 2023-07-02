package ui.security;

import UI.dashboard.AdminDash;
import common.session.AppSession;
import common.utils.UserDTO;
import controller.UTController;
import javax.swing.JOptionPane;
import model.Response;
import ui.dashboard.StudentDash;
import ui.dashboard.TeacherDash;


public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Form");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0, 150));

        jLabel2.setFont(new java.awt.Font("Harrington", 1, 36));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login");

        jLabel3.setFont(new java.awt.Font("Book Antiqua", 1, 18));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("User Name :");

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 1, 18));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password :");

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Arial", 0, 14));

        jPasswordField1.setBackground(new java.awt.Color(204, 204, 204));
        jPasswordField1.setFont(new java.awt.Font("Arial", 0, 14));

        jButton1.setBackground(new java.awt.Color(153, 0, 204));
        jButton1.setFont(new java.awt.Font("Colonna MT", 1, 18));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(jTextField1)))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 370, 340));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\SEMESTERS\\4th semeter\\OOSE\\PROJECT\\User Interfaces\\Wallpaper iPhone_calendar June 2017⚪️.png"));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 680));
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        setSize(new java.awt.Dimension(756, 720));
        setLocationRelativeTo(null);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        
        UserDTO user = new UserDTO();
        // 1. indirection
        //2. pure fabrication
        user.username = jTextField1.getText();
        user.password = new String(jPasswordField1.getPassword());

        Response objResponse = UTController.validateUser(user);
        // MVC = model view Controller

        if (objResponse.hasError()) {
            String errorMessage = objResponse.getErrorMessages();
            JOptionPane.showMessageDialog(null, errorMessage, "Invalid Credentials", JOptionPane.ERROR_MESSAGE);
        } else {
            AppSession session = AppSession.getInstance(user);
            // User is authorized, perform navigation to the respective dashboard based on user type
            String userType = UTController.getUserType();
            System.out.println("user Type is "+ userType);
            switch (userType) {
                case "Admin":
                    AdminDash adminDashboard= new AdminDash(session);
                    adminDashboard.setVisible(true);
                    break;
                case "Student":
                    StudentDash studentDashboard = new StudentDash(session);
                    studentDashboard.setVisible(true);
                    break;
                case "Teacher":
                    
                    TeacherDash teacherDashboard = new TeacherDash(session);
                    teacherDashboard.setVisible(true);
                    break;
                default:
                    System.out.println("There is some erorr");
            }
            this.dispose(); // Close the login form after successful login
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
}
