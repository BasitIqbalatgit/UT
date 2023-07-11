/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Message;
import model.MessageType;
import model.Response;


public class RecordsModifier {

   void deleteSlots(String selectedId, Response objResponse, Connection dbConnection) {
    try {
        PreparedStatement p;
        p = dbConnection.prepareStatement("delete from slots where slotName=?");
        p.setString(1, selectedId);
        int rowsDeleted = p.executeUpdate();
        if (rowsDeleted > 0) {
            objResponse.messagesList.add(new Message("Slot deleted successfully.", MessageType.Information));
        } else {
            objResponse.messagesList.add(new Message("Failed to delete the slot.", MessageType.Warning));
        }
        
    } catch (SQLException e) {
       
        objResponse.messagesList.add(new Message("Ooops! Failed to delete the slot. Please contact support.", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n" + e.getStackTrace(), MessageType.Exception));
    }
}

   
   void deleteCourses(String selectedId, Response objResponse, Connection dbConnection) {
    try {
        PreparedStatement p;
        p = dbConnection.prepareStatement("delete from courses where courseCode=?");
        p.setString(1, selectedId);
        int rowsDeleted = p.executeUpdate();
        if (rowsDeleted > 0) {
            objResponse.messagesList.add(new Message("Courses deleted successfully.", MessageType.Information));
        } else {
            objResponse.messagesList.add(new Message("Failed to delete the Course.", MessageType.Warning));
        }
    } catch (SQLException e) {
        System.out.println("hi i am Basit Iqbal");
        objResponse.messagesList.add(new Message("Ooops! Failed to delete the Courses. Please contact support.", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n" + e.getStackTrace(), MessageType.Exception));
    }
}
    
}
