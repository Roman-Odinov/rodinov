import java.util.*;

/**
 * Создать класс User с полями .
 * Класс User должен реализовать интерфейс Comparable.
 */
public class User implements Comparable<User> {
    private Integer id;
    private String name;
    private Integer age;

    public User(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    // for TreeSet sort()
    @Override
    public int compareTo(User u) {
        return age.compareTo(u.getAge());
    }


    /**
     * написать метод public HashMap<Integer, User> toMap(List<User> list) {},
     * который принимает в себя список пользователей и конвертирует его в Map
     * с ключом Integer id и соответствующим ему User.
     */
    public static HashMap<Integer, User> toMap(List<User> list) {
        HashMap<Integer, User> hashmap = new HashMap<>();
        Integer id;
        for (User user : list) {
            id = user.getId();
            hashmap.put(id, user);
        }
        return hashmap;
    }

    /**
     * Написать метод, который будет возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     */
    public static Set<User> sortAge(List<User> users) {
        TreeSet<User> ts = new TreeSet<>();
        // неявно используем переопределенный compareTo():
        ts.addAll(users);
        return ts;
    }

    /**
     * определить Comparator для метода Collections.sort и отсортировать List<User> по длине имени.
     */
    public static List<User> sortNameLength(List<User> users) {
        Collections.sort(users,
                new Comparator<User>() {
                    @Override
                    public int compare(User u1, User u2) {
                        int len1 = u1.getName().length();
                        int len2 = u2.getName().length();
                        return len1 < len2 ? -1 : (len1 == len2 ? 0 : 1);
                    }
                }
        );
        return users;
    }

    /**
     * определить Comparator для метода Collections.sort и отсортировать List<User> по 2-м полям:
     * сначала проверка по имени, потом по возрасту.
     */
    public static List<User> sortByTwoFields(List<User> users) {
        Collections.sort(users,
                new Comparator<User>() {
                    @Override
                    public int compare(User u1, User u2) {
                        return u1.getName().compareTo(u2.getName());
                    }
                }.thenComparing(
                        new Comparator<User>() {
                            @Override
                            public int compare(User u1, User u2) {
                                return u1.getAge().compareTo(u2.getAge());
                            }
                        }
                )
        );
        return users;
    }


    public static String printIterable(Iterable<?> users) {
        StringBuilder sb = new StringBuilder();
        for (Object user : users) {
            sb.append(user);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String printMap(HashMap<Integer, User> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb.append("Key: ");
            sb.append(entry.getKey());
            sb.append(" Value: ");
            sb.append(entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        users.add(new User(5454, "roman", 37));
        users.add(new User(8797, "roman", 18));
        users.add(new User(1111, "person", 1));
        users.add(new User(2222, "person", 10));
        users.add(new User(1111, "xyligan", 18));
        users.add(new User(7878, "anon", 35));

        System.out.println("initial list:\n" +
                printIterable(users));

        System.out.println("Map<id, User>:\n" +
                printMap(toMap(users)));

        System.out.println("sortAge (TreeSet):\n" +
                printIterable(sortAge(users)));

        System.out.println("sortNameLength:\n" +
                printIterable(sortNameLength(users)));

        System.out.println("sortByTwoFields (name -> age):\n" +
                printIterable(sortByTwoFields(users)));


    }
}
