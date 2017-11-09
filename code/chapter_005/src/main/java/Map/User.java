package Map;

import java.util.*;

/**
 * Создать два объекта User, которые имеют одинаковые поля.
 *
 * Создать карту Map<User, Object>
 *
 * Добавить два объекта. Вывести карту на печать. Описать полученный результат словами.
 */
public class User {

    private String name;
    int children;
    Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }


    public static void main(String[] args) {
        User user1 = new User("roman", 0, new GregorianCalendar(1980, 12, 21));
        User user2 = new User("roman", 0, new GregorianCalendar(1980, 12, 21));
        System.out.println("equals: " + user1.equals(user2));
//        System.out.println(hashCode(user1));

        Map<User, String> map = new HashMap<>();
        map.put(user1, "first");
        map.put(user2, "second");
        System.out.println(map);

        System.out.println(System.identityHashCode(user1));
        System.out.println(System.identityHashCode(user2));

    }
}
