
package controller;

import common.UserDTO;
import model.Authentication;
import model.MySQLConnection;

/**
 *
 * @author CUI
 */
public class Controller {
    static Authentication authenticate = new Authentication();
   
     public static boolean verifyUser(UserDTO user){
          
        return authenticate.verifyUser(user);
        
    }
    
    
    
}
