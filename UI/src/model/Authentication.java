/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.utils.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static model.MySQLConnection.getConnection;


public class Authentication {
    
    public boolean verifyUser(UserDTO user) {
        Connection connection=null;
        try{
            connection=getConnection();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        PreparedStatement statement=null;
        ResultSet result=null;
        
        try{
            String query = "SELECT * FROM user WHERE username= ? and password= ?";
            statement = connection.prepareStatement(query);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            result=statement.executeQuery();
            if(result.next()){
                return true;
            }
        }
        catch(Exception e){
        e.printStackTrace();
        }
        return false;
    }
    
}
