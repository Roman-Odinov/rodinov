package multithreading;


import java.io.*;

/**
 * Создать программу, которая будет считать количество слов и пробелов в тексте.
 * Здесь не надо использовать регулярные выражения. Просто в цикле перебрать символы.
 *
 * Необходимо создать два Thread. Первый будет считать количество слов. Второй количество пробелом в тексте.
 *
 * Вывести результат на экран.
 *
 * Продемонстрировать, что программа выполняется параллельно. Это будет видно по выводу.
 */
public class CountWordsAndSpaces implements Runnable {

    private String fileName;
    private String type;

    public CountWordsAndSpaces(String fileName, String type) {
        this.fileName = fileName;
        this.type = type;
    }

    private void cout(String out) {
        try (FileInputStream in = new FileInputStream(fileName);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {

            int character;
            int wordCounter = 0;
            while ((character = reader.read()) != -1) {
                if (character == 32) {
                    wordCounter++;
                    System.out.println(out + " " + wordCounter);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        if ("words".equals(type)) {
            cout("wordCounter");
        } else if ("spaces".equals(type)) {
            cout("spaces");
        } else {
            System.err.println("Wrong type");
        }

    }


}
