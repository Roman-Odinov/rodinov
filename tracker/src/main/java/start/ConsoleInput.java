package start;

import java.util.Scanner;

/**
 * Принять ввод с консоли.
 *
 */
public class ConsoleInput implements Input{

    private Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param question - запрашиваемый параметр
     * @return  - полученная строка
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
