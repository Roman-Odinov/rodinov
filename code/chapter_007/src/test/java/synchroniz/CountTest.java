package synchroniz;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountTest {

    @Test
    public void testOne() throws InterruptedException {
        Count c1 = new Count(1);
        Count c2 = new Count(1);

        c1.t.join();
        c2.t.join();
    }
}