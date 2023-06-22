
package common.session;

public class AppSession {
    private static AppSession instance;

    private AppSession() {
        // Private constructor to prevent direct instantiation
    }

    public static synchronized AppSession getInstance() {
        if (instance == null) {
            instance = new AppSession();
        }
        return instance;
    }

    // Other methods and properties of the AppSession class
    // ...
}

