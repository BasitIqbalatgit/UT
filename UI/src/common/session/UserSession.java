
package common.session;


public class UserSession {
    private static UserSession instance;

    private UserSession() {
        // Private constructor to prevent direct instantiation (to make only one object)
    }

    public static synchronized UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    // Other methods and properties of the UserSession class down here
    
}

