
package common.utils;


public class UserDTO {
    public String username;
    public String password;   
    public static String type;
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public String getType(){
        return type;
    }
    
    public void setType(String type){
        UserDTO.type=type;
    }
    
    
}
