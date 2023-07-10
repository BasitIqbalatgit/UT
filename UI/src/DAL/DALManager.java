/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import common.utils.CourseDTO;
import common.utils.SlotsDTO;
import common.utils.UserDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Message;
import model.MessageType;
import model.Response;


public class DALManager {
    //Sepration of Concerns
    IConnection objConnection;//Program to interface rather than implementation
    DBReader objReader;
    RecordsMapper objMapper;
     RecordsModifier objModifier;
    //RecordsMapper mapper
    public DALManager(){
        objConnection = new MySQLConnection("jdbc:mysql://localhost:3306/universitytimetable","root","BasitIqbal@050");
        objReader=new DBReader();
        this.objMapper=new RecordsMapper();
        objModifier = new RecordsModifier();
    }
     
    
    public ArrayList<CourseDTO> getCoursesList(){
        Connection dbConnection = objConnection.getConnection();
        ResultSet result = objReader.getRecords("SELECT * FROM courses", dbConnection);
        return objMapper.getCourses(result);
    }
    
     public ArrayList<SlotsDTO> getSlotsList(){
        Connection dbConnection = objConnection.getConnection();
        ResultSet result = objReader.getRecords("SELECT * FROM slots", dbConnection);
        return objMapper.getSlots(result);
    }
    
    public UserDTO getUserResult(UserDTO user){
        System.out.println("hello i am in getUserResult in DAL Mangaer");
         Connection dbConnection = objConnection.getConnection();
         ResultSet result=objReader.getUserResultFromQuery("SELECT * FROM user WHERE username= ? and password= ?", dbConnection,user);
         return objMapper.getUser(result);
    }
    
    
     public Response deleteSlots(String selectedId, Response objResponse) {
         
        try{
            System.out.println("befroe");
            Connection  dbConnection = objConnection.getConnection();
            System.out.println("after");
            System.out.println("in deleteEmployee : "+selectedId);
            objModifier.deleteSlots(selectedId,objResponse,dbConnection);
            System.out.println("after modifier");
            return  objResponse;           
        }catch(Exception e){
              e.printStackTrace();
        objResponse.messagesList.add(new Message("Ooops! Failed to delete employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
        return null;
    }
}
