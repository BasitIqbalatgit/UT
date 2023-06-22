
package controller;

import common.utils.UserDTO;
import model.Authenticate;
import DAL.MySQLConnection;
import common.utils.UTValidator;
import model.Message;
import model.MessageType;
import model.UTFactory;
import model.Response;


public class UTController {
    
     public static Response  validateUser(UserDTO user){
          Authenticate authenticate = new Authenticate();
          
          Response responce = UTFactory.getInstanceOfResponce();
          UTValidator.verifyUser(user, responce);
          if(responce.isSuccessfull()){
              if(!authenticate.authenticateUser(user)){
                responce.messagesList.add(new Message("Plz Enter the Correct Credentials", MessageType.Error));
              }
              
          }
          
           return responce;
        
    }
    
}
