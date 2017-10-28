package start;

import input.Input;

/**
 * Интерфейс UserAction, содержащий методы, общие для всех событий.
 */
public interface UserAction {
    /**
     * User action key.
     *
     * @return
     */
//    int key();    // TODO: delete

    /**
     * Executes actions.
     *
     * @param input
     * @param tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Returns info about actions to be performed.
     *
     * @return String
     */
    String printInfo();
}
