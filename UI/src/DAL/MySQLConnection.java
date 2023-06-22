/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import common.utils.UserDTO;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author CUI
 */
public class MySQLConnection {
    public static String URL="jdbc:mysql://localhost:3306/universitytimetable";
    public static String USERNAME="root";
    public static String PASSWORD="BasitIqbal@050";
    
    public static Connection getConnection() throws SQLException{
            return DriverManager.getConnection(URL,USERNAME,PASSWORD) ;
    }
    
    
}
