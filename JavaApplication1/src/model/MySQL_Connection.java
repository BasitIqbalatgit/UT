/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL_Connection {
    private static final String URL ="jdbc:mysql://localhost:3306/universitytimetable";
                private static final String USERNAME ="root";
                            private static final String PASSWORD ="BasitIqbal@050";
                            
                            public static Connection getConnection() throws SQLException{
                                return DriverManager.getConnection(URL,USERNAME,PASSWORD);
                            }
}
