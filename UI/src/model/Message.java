/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Message {
     public String Message;
    public MessageType Type;

    public Message(String errorMessage, MessageType messageType) {
        this.Message = errorMessage;
        this.Type = messageType;
    }
}
