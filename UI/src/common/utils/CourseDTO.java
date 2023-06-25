package common.utils;

public class CourseDTO {
    public String courseName;
    public String id;
    public int creditHours;
    
    public CourseDTO(String cName, String id, int cHour){
        courseName=cName;
        this.id=id;
        this.creditHours=cHour;
    }
    
    public String getCourseName(){
        return courseName;
    }
    
    public String getId(){
        return id;
    }
    
    public int getCreditHour(){
        return creditHours;
    }
    
    
}
