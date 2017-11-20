package multithreading;

import java.io.File;

public class CountWordsAndSpacesTest2 {

    public static void main(String[] args) /*throws InterruptedException*/ {
        File file = new File("chapter_005/src/main/resources/ltols_wojnaimir.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println("START");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                new CountWordsAndSpaces(absolutePath, "words").count("wordCounter");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                new CountWordsAndSpaces(absolutePath, "spaces").count("spaces");
            }
        });


        t1.start();
        t2.start();


        try {
            System.out.println("Waiting for threads to finish.");
            t1.join(10);
            if (t1.isAlive()) t1.interrupt();    // TODO по сути не останавливает поток
            t2.join(20);
            if (t2.isAlive()) t2.interrupt();
        } catch (InterruptedException e) {
            System.out.println("*************thread is interrupted************");
        }

        System.out.println("Thread One has finished: "
                + !t1.isAlive());
        System.out.println("Thread Two has finished: "
                + !t2.isAlive());
        System.out.println("FINISH");
    }

}