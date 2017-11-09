package Map;

import java.util.*;

/**
 * Перекрывать equals().
 *
 * Создать два объекта User, которые имеют одинаковые поля.
 *
 * Создать карту Map<User, Object>
 *
 * Добавить два объекта с пункта 3 в карту. Вывести карту на печать. Описать полученный результат словами.
 * При этом метод hashCode() остается не переопределенным.
 *
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (!name.equals(user.name)) return false;
        return birthday.equals(user.birthday);
    }

//    @Override
//    public int hashCode() {
//        int result = name.hashCode();
//        result = 31 * result + children;
//        result = 31 * result + birthday.hashCode();
//        return result;
//    }

    public static void main(String[] args) {
        User user1 = new User("roman", 0, new GregorianCalendar(1980, 12, 21));
        User user2 = new User("roman", 0, new GregorianCalendar(1980, 12, 21));
        System.out.println("equals: " + user1.equals(user2));
        System.out.println("user1.hashCode() = " + user1.hashCode());
        System.out.println("user2.hashCode() = " + user2.hashCode());

        Map<User, String> map = new HashMap<>();
        map.put(user1, "first");
        map.put(user2, "second");
        System.out.println(map);

        System.out.println(System.identityHashCode(user1));
        System.out.println(System.identityHashCode(user2));

    }
}
