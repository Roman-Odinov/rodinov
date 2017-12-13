package synchronize;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Создать класс - структуру данных для хранение пользователей UserStorage.
 * 2. В заголовке класса обозначить аннотацию @ThreadSafe из библиотеки
 * 3. Хранилище должно иметь методы boolean add (User user), boolean update(User user), boolean delete(User user).
 * 4. И особый метод transfer(int fromId, int toId, int amount);
 * 5. Структура данных должна быть потокобезопасная;
 * 6. В структуре User Должны быть поля int id, int amount.
 *
 * amount - это сумма денег на счете пользователя.
 *
 * Пример. использования.
 *
 * UserStore stoge = new UserStore();
 *
 * stoge.add(new User(1, 100));
 * stoge.add(new User(2, 200));
 *
 * stoge.transfer(1, 2, 50);
 */
@ThreadSafe
public class UserStorage {

    private final Object userMonitor = new Object();

    private Map<Integer, User> users = new HashMap<>();


    private void log(String s) {
        System.out.println(s);
    }

    @GuardedBy("userMonitor")
    public Map<Integer, User> getUsers() {
        synchronized (userMonitor) {
            return this.users;
        }
    }


    // user`s DAO
    public class UserStorageManager {

        /**
         * Adds User object to storage.
         *
         * @param user
         * @return true if there was no mapping for user, or
         * false if user exists
         */
        @GuardedBy("userMonitor")
        boolean addUser(User user) {
            synchronized (userMonitor) {

                log("ADD\n" + "add position: " + user.getid());

                // Map.put() returns previous value, or null if none
                return users.put(user.getid(), user) == null;
            }
        }

        @GuardedBy("userMonitor")
        boolean update(int id, User user) {
            synchronized (userMonitor) {
                log("UPDATE\nupdate position: " + id + " amount: " + user.getAmount());
                boolean result = false;
                if (users.containsKey(id)) {
                    users.put(id, user);
                    result = true;
                }
                return result;
            }
        }

        @GuardedBy("userMonitor")
        boolean delete(int id) {
            synchronized (userMonitor) {
                log("DELETE\ndelete position: " + id);
                boolean result = false;
                if (users.containsKey(id)) {
                    users.remove(id);
                    result = true;
                }
                return result;
            }
        }

        @GuardedBy("userMonitor")
        boolean transfer(int fromId, int toId, float amount) {
            synchronized (userMonitor) {
                log("TRANSFER\n" +
                        "fromIndex: " + fromId + "\n" +
                        "toIndex: " + toId);

                boolean result = false;

                if (users.containsKey(fromId) &&
                        users.containsKey(toId)) {
                    if (users.get(fromId).getAmount() >= amount) {
                        users.get(fromId).setAmount(users.get(fromId).getAmount() - amount);
                        users.get(toId).setAmount(users.get(toId).getAmount() + amount);
                        result = true;
                    }
                }
                return result;
            }
        }


    }   // UserStorageManager

}   // UserStorage