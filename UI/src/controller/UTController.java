
package controller;

import DAL.DALManager;
import common.utils.UserDTO;
import model.Authenticate;
import common.utils.CourseDTO;
import common.utils.SlotsDTO;
import common.utils.UTValidator;
import java.util.ArrayList;
import model.Message;
import model.MessageType;
import model.UTFactory;
import model.Response;


public class UTController {
    
    DALManager objDAL;
    public UTController(){
        objDAL=UTFactory.getInstanceOfDALManager();
    }
    
    
     public static Response  validateUser(UserDTO user){
          
          System.out.println("hello to the future");
          Response responce = UTFactory.getInstanceOfResponce();
          // 4. Creator
         
          UTValidator.validateUser(user, responce);
          // 5. Sepration of Concerns
          // 6. information expert 
          
          if(responce.isSuccessfull()){
               Authenticate authenticate =UTFactory.getInstanceOfAuthenticate();
          
              if(authenticate.authenticateUser(user)==null){
                responce.messagesList.add(new Message("Plz Enter the Correct Credentials", MessageType.Error));
              }
              
          }
          
           return responce;
        
    }
//     viewSlots(){}
     
     
     public static String getUserType(){
         UserDTO user = new UserDTO();
    String type = user.getType();
         System.out.println("The user type in getUserTupe in Controller is : "+ type);
    return type;
         
     }
     
     
     public ArrayList<CourseDTO> viewCourses (){
         return  objDAL.getCoursesList();
     }
      
public ArrayList<SlotsDTO> viewSlots (){
         return  objDAL.getSlotsList();
     }
     
     public UserDTO UserResult(UserDTO user){
         return objDAL.getUserResult(user);
     }
     
     public Response deleteSlots(String selectedId) {
        Response objResponse = UTFactory.getInstanceOfResponce();
        objDAL.deleteSlots(selectedId, objResponse);
         System.out.println("in delete controler"+ selectedId);
        return objResponse;
    }
    
}
