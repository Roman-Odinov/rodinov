package concurrency;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * ThreadManager test.
 */
public class StopThreadTest extends Thread {

    @Test
    public void stopThread() {

        final int timeLimit = 35;  // ms

        Counter counter = new Counter();
        ThreadManager threadManager = new ThreadManager(counter, timeLimit);  // set time limit to kill 2nd thread

        counter.start();
        threadManager.start();

        try {
            counter.join();
            threadManager.join();
        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted");
        }

        System.out.println("Thread 'counter' has finished: "
                + !counter.isAlive());
        System.out.println("Thread 'threadManager' has finished: "
                + !threadManager.isAlive());
        System.out.println("FINISH");

        // 4764 - real number of space characters in the text fragment
        assertThat("wordCounter should NOT be 4764", counter.wordCounter, is(not(4764)));
    }


}