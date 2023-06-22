
package services;

public class UTAuthorizationService {
    public static boolean hasAccess(String role, String resource) {
        
        if (role.equals("Admin")) {
            return true;  
        } else if (role.equals("Student")) {
            
            if (resource.equals("StudentDashboard")) {
                return true; 
            }
        }
        else if(role.equals("Teacher")){
            if(resource.equals("TeacherDashboard"))
                return true;
        }
        return false;  
    }


}
