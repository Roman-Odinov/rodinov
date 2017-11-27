package concurrency;

/**
 * Stops another Thread by time limit
 */
public class ThreadManager extends Thread {

    private final Thread t;
    private final int limit;

    public ThreadManager(Thread t, int limit) {
        this.t = t;
        this.limit = limit;
    }

    void timeLimiter() throws InterruptedException {
        t.join(limit);                                  // wait for limit, ms
        if (t.isAlive()) t.interrupt();                 // if hasn't finished - stop it by setting flag interrupt
    }


    @Override
    public void run() {
        try {
            timeLimiter();
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }


}
