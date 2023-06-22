/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common.utils;

import common.utils.UserDTO;
import model.Message;
import model.MessageType;
import model.Response;

public class UTValidator {
    public static void verifyUser(UserDTO objUser, Response objResponse) {
        isValidName(objUser.username, objResponse);
        isValidName(objUser.password, objResponse);
        
    }

    private static void isValidName(String nameToValidate, Response objResponse) {
        if(nameToValidate == null || nameToValidate.length() < 3 || nameToValidate.length()>20){
            objResponse.messagesList.add(new Message("User Name OR Password is not valid, Provide valid crdentials with at least 3 characters and atmost 20 characters.",MessageType.Error));
        }
        
    }
    
    
    
}
