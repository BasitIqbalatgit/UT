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
    
    public static void validateSlots(SlotsDTO objSlot, Response objResponse) {
        isValidSlotName(objSlot.slotsName, objResponse);
        if(objResponse.isSuccessfull()){
        isValidTimeFormat(objSlot.startTime, objResponse);
            if(objResponse.isSuccessfull()){
                isValidTimeFormat(objSlot.endTime, objResponse);
            }
        }
    }
    
    private static void isValidSlotName(String nameToValidate, Response objResponse) {
        if (nameToValidate == null || nameToValidate.isEmpty()) {
            objResponse.messagesList.add(new Message("Slot Name is required.", MessageType.Error));
        } else if (nameToValidate.length() < 3 || nameToValidate.length() > 20) {
            objResponse.messagesList.add(new Message("Slot Name should have at least 3 characters and at most 20 characters.", MessageType.Error));
        }
    }

    private static void isValidTimeFormat(String timeToValidate, Response objResponse) {
        if (timeToValidate == null || timeToValidate.isEmpty()) {
            objResponse.messagesList.add(new Message("Time is required.", MessageType.Error));
        } else {
            // Regular expression pattern for HH:MM:SS format
            String timePattern = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
            if (!timeToValidate.matches(timePattern)) {
                objResponse.messagesList.add(new Message("Invalid time format. Please enter time in the format HH:MM:SS", MessageType.Error));
            }
        }
    }
    
    
    
    
    
}
