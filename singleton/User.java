package usts.pycro.singleton;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-08 4:37 PM
 */
public class User {

    private static final User USER = new User();

    public static User getUser() {
        return USER;
    }
}
