package synchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Сделать класс многопоточный счетчик Count#int increment().
 *
 * В заголовке класса указать аннотацию @ThreadSafe
 *
 * Для поля состояния использовать аннотацию @GuardedBy
 *
 * В аннотации GuardedBy - указать объект монитора.
 */
@ThreadSafe
class Count {

    @GuardedBy("this")
    int value = 0;

    /**
     * The Count.increment() method is synchronized on the instance, because
     * the increment() method is an instance method, and marked as synchronized.
     * Therefore only one of the threads can call the increment() method at a time.
     *
     * The other thread will wait until the first thread leaves the increment() method,
     * before it can execute the method itself.
     */
    public synchronized int increment() {
        for(int i=1; i<10; i++) {
            this.value += i;
        }
        return this.value;
    }
}

class CounterThread extends Thread {

    protected Count count = null;

    public CounterThread(Count count) {
        this.count = count;
    }

    public void run() {
        System.out.println(count.increment());
    }
}
