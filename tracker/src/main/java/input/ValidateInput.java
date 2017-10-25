package input;

import helpers.MenuOutException;

/**
 * Ввод с консоли с валидацией возвращаемых данных.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Handling Exceptions.
     * @param question
     * @param range
     * @return int
     */
    @Override
    public int ask(String question, int[] range) {
        int value = -1;
        boolean invalidInput = true;
        do {
            try {
                value = super.ask(question, range);
                invalidInput = false;
            } catch (MenuOutException moe) {            // out of boundary Exception handling
                System.err.println("Entered number is out of range");
            } catch (NumberFormatException nfe) {       // not-a-digit handling
                System.err.println("Incorrect input, try again");
            }
        } while (invalidInput);
        return value;
    }
}
