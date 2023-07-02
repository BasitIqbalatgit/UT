
package controller;

import DAL.DALManager;
import common.utils.UserDTO;
import model.Authenticate;
import common.utils.CourseDTO;
import common.utils.UTValidator;
import java.util.ArrayList;
import model.Message;
import model.MessageType;
import model.UTFactory;
import model.Response;
import java.sql.ResultSet;


public class UTController {
    
    DALManager objDAL;
    public UTController(){
        objDAL=UTFactory.getInstanceOfDALManager();
    }
    
    
     public static Response  validateUser(UserDTO user){
          
          System.out.println("hello to the future");
          Response responce = UTFactory.getInstanceOfResponce();
          // 4. Creator
          Authenticate authenticate =UTFactory.getInstanceOfAuthenticate();
          
          UTValidator.validateUser(user, responce);
          // 5. Sepration of Concerns
          // 6. information expert 
          
          if(responce.isSuccessfull()){
              if(authenticate.authenticateUser(user)==null){
                responce.messagesList.add(new Message("Plz Enter the Correct Credentials", MessageType.Error));
              }
              
          }
          
           return responce;
        
    }
     
     
     
     public static String getUserType(){
         UserDTO user = new UserDTO();
    String type = user.getType();       
    return type;
         
     }
     
     
     public ArrayList<CourseDTO> viewCourses (){
         return  objDAL.getCoursesList();
     }
     
     
     public UserDTO UserResult(UserDTO user){
         return objDAL.getUserResult(user);
     }
    
}
