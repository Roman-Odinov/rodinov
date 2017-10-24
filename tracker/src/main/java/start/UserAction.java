package start;

/**
 * Интерфейс UserAction, содержащий методы, общие для всех событий
 */
public interface UserAction {
    /**
     * User action key
     * @return
     */
    int key();

    /**
     * Executes actions
     * @param input
     * @param tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Informs the user about actions to be performed
     * @return
     */
    String printInfo();
}
