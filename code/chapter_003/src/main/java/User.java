import java.util.*;

/**
 * Создать класс User с полями id, name, city.
 */
public class User {
    private Integer id;
    private String name;
    private String city;

    public User(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    /**
     * Cоздать клаcc UserConvert.
     */
    public static class UserConvert {
        /**
         * написать метод public HashMap<Integer, User> process(List<User> list) {},
         * который принимает в себя список пользователей и конвертирует его в Map
         * с ключом Integer id и соответствующим ему User.
         */
        public static HashMap<Integer, User> process(List<User> list) {

            HashMap<Integer, User> hashmap = new HashMap<>();

            for (User user : list) {
                Integer id = user.getId();
                hashmap.put(id, user);
            }

            return hashmap;
        }
    }

    // print Map
    public static String printMap(HashMap<Integer, User> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb.append("Key: " + entry.getKey() + " Value: " + entry.getValue());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        users.add(new User(5454, "roman", "moscow"));
        users.add(new User(1111, "xyligan", "moscow"));
        users.add(new User(1111, "another person with same id", "vologda"));
        users.add(new User(3454344, "anon", "NY"));

        System.out.println(printMap(UserConvert.process(users)));
    }
}
