package Threads;

import java.io.*;

/**
 * Считает количество пробелов в тексте.
 */
public class Counter extends Thread {

    private final File file = new File("src/main/resources/ltols_wojnaimir.txt");
    private final String fileName = file.getAbsolutePath();
    public int wordCounter = 0;


    private void worker() throws InterruptedException {

        try (FileInputStream in = new FileInputStream(fileName);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {

            int character;

            long startTime = System.nanoTime();

            while ((character = reader.read()) != -1) {

                if (Thread.currentThread().isInterrupted()) break;

                /*         set delay            */
//                Thread.sleep(0, 200);

                if (character == 32) {
                    wordCounter++;
                    System.out.println("wordCounter = " + wordCounter);
                }
            }

            System.out.println("final wordCounter = " + wordCounter);

            long stopTime = System.nanoTime();
            long delayTime = (stopTime - startTime);
            System.out.printf("spent time for wordCounter = %s ms %n", delayTime / 1000000);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        try {
            System.out.println("Counter started");
            worker();
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }

    }
}
