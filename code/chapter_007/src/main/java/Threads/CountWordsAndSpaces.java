package Threads;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Создать программу, которая будет считать количество слов и пробелов в тексте.
 * Здесь не надо использовать регулярные выражения. Просто в цикле перебрать символы.
 *
 * Необходимо создать два Thread. Первый будет считать количество слов. Второй количество пробелом в тексте.
 *
 * Вывести результат на экран.
 *
 * Необходимо, что бы вначале запуска программы из первой части на экране выводилась информация о программа.
 * А после вычисления данных, выводилась запись о завершении программы.
 * Важно, эта информация всегда должна выводиться в начале и в конце вычисления.
 *
 * Предусмотреть возможность останавливать вычисления, если время вычисления превышает 1 секунде.
 * Для этого нужно реализовать проверку поведения isInterrunt()
 */
public class CountWordsAndSpaces /*implements Runnable */ {

    private String fileName;
    private String type;
//    Thread t;


    public CountWordsAndSpaces(String fileName, String type) {
        this.fileName = fileName;
        this.type = type;
//        t = new Thread(this);
    }

    public void count(String out) /*throws InterruptedException*/ {
        try (FileInputStream in = new FileInputStream(fileName);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {

            int character;
            int wordCounter = 0;

            long startTime = System.nanoTime();

            while ((character = reader.read()) != -1) {

                if (Thread.currentThread().isInterrupted()) break;  // TODO не трудозатратно ли?
                /*// set delay
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println(String.format("%s%s", Thread.currentThread().getName(), " time`s up!!!!!!"));
                }*/

                if (character == 32) {
                    wordCounter++;
                    System.out.println(out + " " + wordCounter);
                }
            }

            System.out.println("final " + out + " = " + wordCounter);

            long stopTime = System.nanoTime();
            long delayTime = (stopTime - startTime);
            System.out.printf("spent time for %s = %s ms %n", out, delayTime / 1000000);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


//    @Override
//    public void run() {
//        if ("words".equals(type)) {
//            count("wordCounter");
//        } else if ("spaces".equals(type)) {
//            count("spaces");
//        } else {
//            System.err.println("Wrong type");
//        }
//    }


}
