package synchronize;

import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;

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
public class UserStorage /*extends Thread */ {

    private final Object userMonitor = new Object();

    private HashMap<Integer, User> users = new HashMap<>();
//    private HashMap<Integer, User> users;


//    /**
//     * create user`s storage
//     */
//    public void createStorage(){
//        this.users = new HashMap<>();
//    }

//    public void createUserMonitor(){
//        this.userMonitor = new Object();
//    }

    private void log(String s) {
        System.out.println(s);
    }

    public HashMap<Integer, User> getUsers() {
        return this.users;
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
        boolean addUser(User user) {
            log("ADD\n" + "add position: " + user.getid());

            // Map.put() returns previous value, or null if none
            return users.put(user.getid(), user) == null;
        }


        boolean update(int id, User user) {
            log("UPDATE\nupdate position: " + id + " amount: " + user.getAmount());
            boolean result = false;
            if (users.containsKey(id)) {
                users.put(id, user);
                result = true;
            }
            return result;
        }


        boolean delete(int id) {
            log("DELETE\ndelete position: " + id);
            boolean result = false;
            if (users.containsKey(id)) {
                users.remove(id);
                result = true;
            }
            return result;
        }


        boolean transfer(int fromId, int toId, float amount) {
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


    }   // UserStorageManager

}   // UserStorage