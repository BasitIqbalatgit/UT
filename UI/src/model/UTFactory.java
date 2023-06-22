/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.UTController;



public class UTFactory {
    public static UTController getInstanceOfController(){
        return new UTController();
    }
    
    public static Response getInstanceOfResponce(){
        return new Response();
    }
    
    
}
