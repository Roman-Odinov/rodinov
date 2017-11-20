package multithreading;

/**
 * Stops another Thread by time limit
 */
public class ThreadManager extends Thread {

    private final Thread t;
    private final int LIMIT;

    public ThreadManager(Thread t, int limit) {
        this.t = t;
        this.LIMIT = limit;
    }

    void TimeLimiter() throws InterruptedException {
        t.join(LIMIT);                                  // wait for LIMIT, ms
        if (t.isAlive()) t.interrupt();                 // if hasn't finished - stop it by setting flag interrupt
    }


    @Override
    public void run() {
        try {
            TimeLimiter();
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }
    }


}
