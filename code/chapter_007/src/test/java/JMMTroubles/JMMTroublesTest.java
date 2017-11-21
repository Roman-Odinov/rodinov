package JMMTroubles;

import org.junit.Test;

/**
 * Пример, иллюстрирующий проблемы, которые могут случиться при использовании многопоточности.
 * Часть кода, создающего объекты взята отсюда:
 * http://tutorials.jenkov.com/java-concurrency/java-memory-model.html
 */
public class JMMTroublesTest {

    /**
     * Separate primitives in THREAD STACK.
     *
     * Each thread has ITS OWN INSTANCE of primitive (int).
     */
    @Test
    public void ThreadStackPrimitivesTest() throws InterruptedException {

        System.out.println("----------- THREAD STACK. primitive (int)");
        Thread t1 = new Thread(new MyRunnable1(true), "Thread #1");
        t1.start();
        Thread t2 = new Thread(new MyRunnable1(false), "Thread #2");
        t2.start();

        t1.join();
        t2.join();
    }

    /**
     * Separate objects in HEAP.
     *
     * Each thread has ITS OWN INSTANCE of object(Integer).
     */
    @Test
    public void HeapSepareateObjectInstanceTest() throws InterruptedException {

        System.out.println("----------- HEAP. Separated instances of object(Integer)");
        Thread t1 = new Thread(new MyRunnable3(true), "Thread #1");
        t1.start();
        Thread t2 = new Thread(new MyRunnable3(false), "Thread #2");
        t2.start();

        t1.join();
        t2.join();
    }

    /**
     * Race Conditions.
     *
     * Static object, shared with 2 threads.
     */
    @Test
    public void RaceConditionTest() throws InterruptedException {

        System.out.println("----------- Static object, shared with 2 threads.");
        Thread t1 = new Thread(new MyRunnable2(), "Thread #1");
        t1.start();
        Thread t2 = new Thread(new MyRunnable2(), "Thread #2");
        t2.start();

        t1.join();
        t2.join();
    }


}