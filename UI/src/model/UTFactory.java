
package model;

import controller.UTController;
import DAL.DALManager;


public class UTFactory {
    public static UTController getInstanceOfController(){
        return new UTController();
    }
    
    public static Response getInstanceOfResponce(){
        return new Response();
    }
    
    public static Authenticate getInstanceOfAuthenticate(){
        return new Authenticate();
    }
    
    public static DALManager getInstanceOfDALManager(){
        return new DALManager();
    }
    
}
