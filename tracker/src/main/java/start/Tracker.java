package start;

import models.*;
import java.util.*; // Random, Arrays

/**
 * class Tracker.
 * creates and manupulates array Item
 */
public class Tracker {
    int itemsCount = 100;
    Item[] items = new Item[itemsCount];
    public int position = 0;   // позиция заполнения очередного элемента в массиве items. Оно же - количество заполненных элементов.
    private static final Random RND = new Random(System.currentTimeMillis());


    /**
     * добавляет заявку, переданную в аргументах в массив заявок
     * @param item
     * @return Item -- зачем нужен возврат?
     */
    public Item add(Item item) {
        item.setId(generateId());   // генерим свежий id для нового элемента
        items[position] = item;    // в массив добавляем
        position++;
        return item;
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
        /**
         * всё из-за того, что выдать нужно массив из того кол-ва элементов, насколько массив заполнен
         * но array не позволяет изменять размерность по мере заполнения
         * задавать массив на масимум тоже не резонно...
         * используем ArrayList
         * ( второй вариант - обрезать массив до возврата)
         */
        List<Item> result = new ArrayList<>();
        String gottenName;
        for(int index = 0; index < position; index++ ) {
            gottenName = items[index].getName();
            if(gottenName != null && name.equals(gottenName)) {     // NullPointerException fix
                result.add(items[index]);
            }
        }
        // приводим к типу массив
        Item[] array = result.toArray(new Item[result.size()]);
        return array;
    }


    /**
     * редактирование заявок
     * обновление элемента, если
     * (а) найден такой же id
     * и
     * (б) пройдена валидация обновленных полей
     */
    public void update(Item updatedItem) {
        /**
         из получаемого объекта выжать id
         найти такой же id в существующем массиве
         проверить валидность полей
         этому элементу присвоить весь переданный item (все поля)
         */
        String updatedId = updatedItem.getId();
        for(int index = 0; index < position; index++ ) {
            if ((items[index].getId()).equals(updatedId)) {         // нашли оригинал заявки в базе
                if(checkFieldsOK(updatedItem)) {                    // поля валидны
                    items[index] = null;
                    items[index] = updatedItem;                         // обновили заяву
                    return;  // следующего цикла не будет - id уникален
                } else {    // проверка полей не прошла
                    System.out.println("The fields are incorrect or empty!");
                    return;
                }
            }
        }
        System.out.println("Error: The Id not found");
    }


    /**
     * получение заявки по id
     * @param id
     * @return элемент класса Item
     */
    protected Item findById(String id) {                       // protected пока для тестов
        Item result = null;       // должны вернуть null если элемент не найден
        for(int index = 0; index < position; index++ ) {
            if (items[index].getId().equals(id)) {
                result = items[index];
                break;
            }
        }
        return result;
    }


    /**
     * удаление заявок
     * @param itemToDelete
     */
    public void delete(Item itemToDelete) {
        /**
         по id найти и удалить, сдвинув массив;
         */
        for(int index = 0; index < position; index++ ) {
            if((items[index].getId()).equals(itemToDelete.getId())) {    // нашли оригинал заявки в базе
                // вызвать метод сдвига
                // сдвиг должен возвращать ТОТ ЖЕ САМЫЙ МАССИВ
                shift(index);
                break;
            }
        }
    }




    /**
     * создание уникального идентификатора
     * @return String
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RND.nextInt());
    }


    /**
     * проврка валидности полей объекта
     */
    private boolean checkFieldsOK(Item item) {
        // проверка instanceof здесь избыточна, но пусть будет
        if(item.getId() != "" && item.getId() instanceof String &&
                item.getName() != "" && item.getName() instanceof String &&
                item.getDescription() != "" && item.getDescription() instanceof String){
            return true;
        }
        return false;
    }


    /**
     * сдвигаем items начиная с позиции index влево, укорачивая на 1
     * @param index
     */
    private void shift(int index) {
        /**
         * нельзя уменьшать размер возвратного массива, т.к. увеличить его нет возможности - не сможем добавлять элементы
         */
//        int new_arrSize = position -1;  // новый массив, соотв., будет на 1 меньше оригинального
        Item[] arr_new = new Item[itemsCount];
        // заполням ДО index
        System.arraycopy(items, 0, arr_new, 0, index );
        // заполняем С index до конца
        System.arraycopy(items, index+1, arr_new, index, position - index - 1);
        // возвращаем в оригинальный массив
        items = Arrays.copyOf(arr_new, itemsCount);
        position--;
    }

}
