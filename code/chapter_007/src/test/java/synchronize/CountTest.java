package synchronize;

import org.junit.Test;

public class CountTest {

    @Test
    public void testOne() throws InterruptedException {
        Count count = new Count();
        Thread threadA = new CounterThread(count);    // count у нас один на оба треда
        Thread threadB = new CounterThread(count);

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }
}