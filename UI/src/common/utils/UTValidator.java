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
    public static void validateUser(UserDTO objUser, Response objResponse) {
        isValidName(objUser.username, objResponse);
        if(objResponse.isSuccessfull()){
        isValidPassword(objUser.password, objResponse);
        }
        
    }

    private static void isValidName(String nameToValidate, Response objResponse) {
        if(nameToValidate == null || nameToValidate.length() < 3 || nameToValidate.length()>20){
            objResponse.messagesList.add(new Message("User Name OR Password is not valid, Provide valid crdentials with at least 3 characters and atmost 20 characters.",MessageType.Error));
        }
        
    }
    private static void isValidPassword(String passwordToValidate, Response objResponse) {
        if(passwordToValidate == null || passwordToValidate.length() < 3 || passwordToValidate.length()>9){
            objResponse.messagesList.add(new Message("User Name OR Password is not valid, Provide valid crdentials with at least 3 characters and atmost 8 characters.",MessageType.Error));
        }
        
    }
    
    
    
}
