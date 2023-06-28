/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import common.utils.CourseDTO;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
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
                objCourse.creditHours=parseInt(rs.getString(3));
                   
                emplist.add(objCourse);
            }
        }catch (Exception e){
        }
        return emplist;
    }
    
}

