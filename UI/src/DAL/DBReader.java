/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.ResultSet;
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
        catch (Exception e) {
            System.out.println("Error Trace in getRecords() : " + e.getMessage());
        }
        return null;
    }
    
}