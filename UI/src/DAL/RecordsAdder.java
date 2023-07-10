package DAL;

import common.utils.SlotsDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Message;
import model.MessageType;
import model.Response;

public class RecordsAdder {


    public void saveSlots(SlotsDTO objSlots, Response objResponse, Connection dbConnection) {
        try {
            String query = "INSERT INTO slots (id,slotName, startTime, endTime) VALUES (?,?, ?, ?);";
            PreparedStatement p = dbConnection.prepareStatement(query);
            int id = SlotsDTO.id++;
                String idAsString = Integer.toString(id);
            p.setString(1,idAsString);
            p.setString(2, objSlots.slotsName);
            p.setString(3, objSlots.startTime);
            p.setString(4, objSlots.endTime);
            int rowsInserted = p.executeUpdate();
            if (rowsInserted > 0) {
                objResponse.messagesList.add(new Message("Slot added successfully.", MessageType.Information));
            } else {
                objResponse.messagesList.add(new Message("Failed to add slot.", MessageType.Error));
            }
        } catch (SQLException e) {
            System.out.println("Error while saving slot.");
            objResponse.messagesList.add(new Message("Failed to create slot. Please contact support for assistance.", MessageType.Error));
            objResponse.messagesList.add(new Message(e.getMessage(), MessageType.Exception));
        }
    }
}
