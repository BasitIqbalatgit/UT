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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author CUI
 */
public class MySQLConnection implements IConnection{
    public static String URL;
    public static String USERNAME;
    public static String PASSWORD;
    public MySQLConnection (String url, String username, String password){
        this.URL=url;
        this.USERNAME=username;
        this.PASSWORD=password;
        
    }
    @Override
    public  Connection getConnection() {
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD) ;
        } catch (Exception ex) {
            System.out.println("Error TRace in getConnection() : "+ ex.getMessage());
        }
        return null;        
    }
    
    
}
