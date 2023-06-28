/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import common.utils.CourseDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DALManager {
    IConnection objConnection;
    DBReader objReader;
    RecordsMapper objMapper;
    //RecordsMapper mapper
    public DALManager(){
        objConnection = new MySQLConnection("jdbc:mysql://localhost:3306/universitytimetable","root","BasitIqbal@050");
        objReader=new DBReader();
        this.objMapper=new RecordsMapper();
        
    }
    
    
    public ArrayList<CourseDTO> getCoursesList(){
        Connection dbConnection = objConnection.getConnection();
        ResultSet result = objReader.getRecords("SELECT * FROM courses", dbConnection);
        return objMapper.getCourses(result);
    }
}
