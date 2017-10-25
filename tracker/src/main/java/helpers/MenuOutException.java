package helpers;

/**
 * Throw exception named 'MenuOutException' with msg.
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
