package synchroniz;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Сделать класс многопоточный счетчик Count#int incremant().
 *
 * В заголовке класса указать аннотацию @ThreadSafe
 *
 * Для поля состояния использовать аннотацию @GuardedBy
 *
 * В аннотации GuardedBy - указать объект монитора.
 */
@ThreadSafe
public class Count implements Runnable {

    private Integer value;
    public Thread t = new Thread(this);

    public Count(Integer value) {
        this.value = value;
        t.start();
    }

    @GuardedBy("ClassName.class")
    int increment(Integer value) {
        for(Integer i=1; i<100; i++){
            value += i;
        }
        return value;
    }

    @Override
    public void run() {

        System.out.println(increment(value));
    }
}
