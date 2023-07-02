/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.utils.UserDTO;
import controller.UTController;


public class Authenticate {
    
    public Authenticate(){}
    
    public UserDTO authenticateUser(UserDTO user) {             
               UTController controller = new UTController();
            UserDTO result = controller.UserResult(user);
            return result;     
    }
    
}
