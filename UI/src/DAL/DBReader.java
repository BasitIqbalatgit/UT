/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import common.utils.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CUI
 */
public class DBReader {

    ResultSet getRecords(String dblQuery,Connection conn) {
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(dblQuery);            
        }
        catch (SQLException e) {
            System.out.println("Error Trace in getRecords() : " + e.getMessage());
        }
        return null;
    }
    
     ResultSet getUserResultFromQuery(String query, Connection conn, UserDTO user) {
    try {
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        System.out.println("Executing query: " + statement.toString()); // Debug statement
        return statement.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
    
    
}