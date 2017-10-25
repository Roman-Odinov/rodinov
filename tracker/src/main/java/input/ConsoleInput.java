package input;

import helpers.MenuOutException;

import java.util.Scanner;

/**
 * Реализация интерфейса ввода.
 * Ввод с консоли.
 */
public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * If answer not in allowed range - throw MenuOutException()
     * @param question: String
     * @param range: int[]
     * @return int
     */
    @Override
    public int ask(String question, int[] range) {
        System.out.println(question);
        int answer = Integer.valueOf(scanner.nextLine());
        boolean inRange = false;
        for (int value : range) {
            if (answer == value) {
                inRange = true;
                break;
            }
        }
        if (inRange) {      // in range
            return answer;
        } else {            // out of boundary
            throw new MenuOutException("out of boundary!");
        }
    }

}
