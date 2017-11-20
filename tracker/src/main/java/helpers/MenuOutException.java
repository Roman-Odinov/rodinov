package helpers;

/**
 * Exception 'Menu out of boudary'.
 */
public class MenuOutException extends RuntimeException {

    /**
     * Throw exception named 'MenuOutException' with msg.
     *
     * @param msg
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
