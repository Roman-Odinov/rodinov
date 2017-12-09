package synchronize;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Пример. использования.
 *
 * UserStore stoge = new UserStore();
 *
 * stoge.add(new User(1, 100));
 * stoge.add(new User(2, 200));
 *
 * stoge.transfer(1, 2, 50);
 */
public class UserStorageTest {

    UserStorage storage = new UserStorage();
    UserStorage.UserStorageManager manager = storage.new UserStorageManager();


    private void printAllUsers(String s) {
        System.out.println(s);
        for (Map.Entry<Integer, User> entry : storage.getUsers().entrySet()) {
            System.out.println("User: " + entry.getKey() + " Amount: "
                    + entry.getValue().getAmount());
        }
    }

    @Test
    public void whenAddAndThenUpdateShouldReturnLastChangedAmount() throws Exception {


        System.out.println("--------------------------------------------------");

        Thread t1 = new Thread(() -> manager.addUser(new User(0, 577.44f)));

        Thread t2 = new Thread(() -> manager.update(0, new User(0, 456.33f)));

        Thread t3 = new Thread(() -> manager.update(0, new User(0, 589.00f)));

        // add into storage
        t1.start();
        t1.join();
        printAllUsers("initial-");

        //edit user
        t2.start();
        t3.start();
        t2.join();
        t3.join();

        printAllUsers("after update-");
        assertThat(this.storage.getUsers().get(0).getAmount(), is(589.00f));

    }

    @Test
    public void whenSendMoneyShouldIncreaseAndDecrease() throws InterruptedException {


        System.out.println("--------------------------------------------------");

        Thread t1 = new Thread(() -> manager.addUser(new User(2, 1000.89f)));
        Thread t2 = new Thread(() -> manager.addUser(new User(3, 0.89f)));

        // add users
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        printAllUsers("after add users:");

        Thread t3 = new Thread(() -> manager.transfer(2, 3, 154.27f));

        Thread t4 = new Thread(() -> manager.transfer(2, 3, 154.27f));

        // send money two times
        t3.start();
        t4.start();
        t3.join();
        t4.join();

        printAllUsers("after send money two times");

        assertThat(this.storage.getUsers().get(2).getAmount(), is(692.35f));
        assertThat(this.storage.getUsers().get(3).getAmount(), is(309.43f));
    }


}