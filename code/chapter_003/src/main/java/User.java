import java.util.*;

/**
 * Создать класс User с полями .
 * Класс User должен реализовать интерфейс Comparable.
 */
public class User implements Comparable<User> {
    private Integer id;
    private String name;
    private String city;
    private Integer age;

    public User(Integer id, String name, String city, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public int compareTo(User u) {
        return age.compareTo(u.getAge());
    }


    /**
     * написать метод public HashMap<Integer, User> process(List<User> list) {},
     * который принимает в себя список пользователей и конвертирует его в Map
     * с ключом Integer id и соответствующим ему User.
     */
    public static HashMap<Integer, User> process(List<User> list) {

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
     *
     * @return
     */
    public static Set<User> sort(List<User> users) {
        TreeSet<User> ts = new TreeSet<>();
        ts.addAll(users);
        return ts;
    }

    public static String printList(List<User> arrList) {
        StringBuilder sb = new StringBuilder();
        for (User l : arrList) {
            sb.append(l);
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

    public static String printSet(Set<User> users) {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        users.add(new User(5454, "roman", "moscow", 37));
        users.add(new User(1111, "person", "vologda", 0));
        users.add(new User(1111, "xyligan", "moscow", 18));
        users.add(new User(3454344, "anon", "NY", 35));

        System.out.println("initial list:\n" + printList(users));

//        printMap(process(users));

        System.out.println("sorted TreeSet:\n" + printSet(sort(users)));
    }
}
