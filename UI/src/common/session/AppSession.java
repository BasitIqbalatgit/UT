
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
        return instance != null;
    }

    public UserDTO getCurrentUser() {
        return currentUser;
    }
    
    public static void disposeInstance(){
        instance = null;
    }
    
    
}

