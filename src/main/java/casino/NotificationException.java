package casino;

/**
 * A Class that represent as the custom exception class which can own its message
 */
public class NotificationException extends Exception {

    public NotificationException(String Message){
        super(Message);
    }

}
