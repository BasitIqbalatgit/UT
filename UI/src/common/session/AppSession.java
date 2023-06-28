
package common.session;

import common.utils.UserDTO;

public class AppSession {
    private static AppSession instance;
    UserDTO currentUser;

    private AppSession(UserDTO cUser) {
     currentUser = cUser;
    }

    public static synchronized AppSession getInstance(UserDTO cUser) {
        if (instance == null) {
            instance = new AppSession(cUser);
        }
        return instance;
    }
    
    
    public static boolean isAuthorized(){
        if(instance == null){
            return false;
        }
        return true;
    }

    public Object getCurrentUser() {
        return currentUser;
    }
    
    
    
}

