package common.utils;

public class CourseDTO {
    public String id;
    public String courseName;
    public String courseCode;
    public int creditHours;
    
    
    
    public String getCourseName(){
        return courseName;
    }
    
    public String getCourseCode(){
        return courseCode;
    }
    
    public int getCreditHour(){
        return creditHours;
    }
    
    
}
