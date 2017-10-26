package input;

/**
 * Интерфейс ввода.
 */
public interface Input {
    /**
     * Method ask: print question, take answer from command line.
     *
     * String version.
     *
     * @param question: String
     * @return String
     */
    String ask(String question);

    /**
     * Method ask: print question, check if it is in range,
     * take answer from command line.
     *
     * int version.
     *
     * @param question: String
     * @param range:    int[]
     * @return int
     */
    int ask(String question, int[] range);

}
