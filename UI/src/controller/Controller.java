
package controller;

import common.UserDTO;
import model.Authentication;
import model.MySQLConnection;


public class Controller {
    static Authentication authenticate = new Authentication();
   
     public static boolean verifyUser(UserDTO user){
          
        return authenticate.verifyUser(user);
        
    }
    
}
