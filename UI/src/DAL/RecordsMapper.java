/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import common.utils.CourseDTO;
import common.utils.SlotsDTO;
import common.utils.UserDTO;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author CUI
 */
public class RecordsMapper {
    public RecordsMapper(){}

    ArrayList<CourseDTO> getCourses(ResultSet rs) {
        ArrayList<CourseDTO> emplist = new ArrayList<>();
        try{
        while (rs.next())
            {
                  
              
                
                   CourseDTO objCourse=new CourseDTO();  
                objCourse.id=rs.getString(1);
                objCourse.courseName=rs.getString(2);
                objCourse.courseCode=rs.getString(3);
                objCourse.creditHours=parseInt(rs.getString(4));
                   
                emplist.add(objCourse);
                emplist.add(objCourse);
                
            }
        }catch (Exception e){
        }
        System.out.println("emplist is ;"+emplist);
        return emplist;
    }

    
    
     ArrayList<SlotsDTO> getSlots(ResultSet rs) {
        ArrayList<SlotsDTO> emplist = new ArrayList<>();
        try{
        while (rs.next())
            {
                SlotsDTO objSlots=new SlotsDTO(); 
                
                objSlots.slotsName=rs.getString(1);
                objSlots.startTime=rs.getString(2);
                objSlots.endTime=(rs.getString(3));
                objSlots.duration=(rs.getString(4));   
                emplist.add(objSlots);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return emplist;
    }
    
    
    
     UserDTO getUser(ResultSet rs) {
    UserDTO user = new UserDTO();
    try {
        if (rs.next()) {
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setType(rs.getString("type"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return user;
}
    
}

