package start;

import models.*;
import java.util.*; // Random, Arrays

/**
 * 1. Реализовать класс Tracker. Класс трекер - это обертка над массивом;
 2. В классе должно быть поле private Item[] items = new Item[100];
 3. Данный класс используется, как хранилище для заявок;
 4. В нем должны быть следующие методы:
 добавление заявок - public Item add(Item);
 редактирование заявок - public void update(Item);
 удаление заявок - public void delete(Item);
 получение списка всех заявок - public Item[] getAll();
 получение списка по имени - public Item[] findByName(String key);
 получение заявки по id - public Item findById(String id);

 5. На все методы необходимо написать тесты.

 В программе на данном этапе не должно быть ввода и вывода данных;
 В классе Tracker не должно быть метода public static void main(String[] args).
 В этом задании надо создать только два класса Item и Tracker.
 */
public class Tracker {
    // default:  available to any other class in the same package
    // private: Accessible only within the declared class itself.   и для созданного объекта
    private Item[] items = new Item[100];
    private int position = 0;
    // static : All instances share the same copy of the variable.
    private static final Random RND = new Random(System.currentTimeMillis());

    /**
     * добавляет заявку, переданную в аргументах в массив заявок
     * @param item
     * @return
     */
    /*
    Зачем он возвращает заявку пока непонятно
     */
    public Item add(Item item) {
        item.setId(generateId());   // генерим свежий id для нового элемента
        this.items[position] = item;    // в массив добавляем
        position++;
        return item;
    }

    /**
     * редактирование заявок
     * @param item
     */
    public void update(Item item) {
        // из получаемой выжать id
        // найти такой же id в существующем массиве
        // этому элементу присвоить переданный item
        // возможно проверить валидность полей
    }

    /**
     * удаление заявок
     * @param item
     */
    public void delete(Item item) {
        // по id найти и удалить, сдвинув массив
    }


    /**
     * получение списка всех заявок
     * выдергиваем только те, что заполнены
     * @return массив класса Item
     */
    public Item[] getAll() {
        // position - счетчик --> по нему можно ориентировать размер массива
        // в методе Arrays.copyOfRange() последний параметр - невключительный элемент
        return Arrays.copyOfRange(items, 0, position);
    }


    /**
     * получение списка по имени
     * @param name
     * @return массив класса Item
     */
    public Item[] findByName(String name) {
        return null;
    }


    /**
     * получение заявки по id
     * @param id
     * @return элемент класса Item
     */
    protected Item findById(String id) {                       // protected пока для тестов
        Item result = null;       // почему так?
//        Item result = new Item();     // так тоже работает
        for(Item item: items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }



    /**
     * создание уникального идентификатора
     * @return String
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RND.nextInt());
    }







    /*public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.items[0] = new Item("item, ", "description, ", 1);
        tracker.items[1] = new Task("task, ", "descr, ");
        tracker.items[2] = new Bug();

//        tracker.add(new Task("first name, ", "first descr"));



        *//*for (Item item : tracker.items) {
            if (item instanceof Task) {      // проверка на принадлежность объекта к классу
                Task task = (Task) item;    // приведение типов: объекта item к типу Task
                System.out.println(item.name + item.description + task.calculatePrice()); // и здесь обращение уже к task
            } else {
                System.out.println(item.name + item.description);
            }
        }*//*


    }*/

}
