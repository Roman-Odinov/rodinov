package start;

import models.*;

import java.util.*;

/**
 * В консоли отображается приветствие и описание программы.
 * После этого пользователю отображается консольное меню: Список всех действий, которые поддерживаются в системе.
 * Пользователю предлагается выбирать действие, которое он хочет совершить.
 * Когда действие закончено, пользователю опять отображается меню.
 *
 * При запуске класса StartUI пользователю отображается следующее меню:
 0. Add new Item
 1. Show all items
 2. Edit item
 3. Delete item
 4. Find item by Id
 5. Find items by name
 6. Exit Program
 Select:
 *
 */
public class StartUI {

    /**
     * вот использование полиморфизма:
     * принимаем все объекты , реализованные от интерфейса Input
     * а объекты могут иметь совершенно разную реализацию полей интерфейса
     */
    private Input input;

    /**
     * Пустой конструктор для вспомогательных методов
     */
    public StartUI(){}


    public StartUI(Input input) {
        this.input = input;
    }


    private String options = "\nPlease select:\n"
            + "0. Add new Item\n"
            + "1. Show all items\n"
            + "2. Edit item\n"
            + "3. Delete item\n"
            + "4. Find item by Id\n"
            + "5. Find items by name\n"
            + "6. Exit Program\n";


    /**
     * Create new Tracket item
     * @param input
     * @param tracker
     */
    private void createItem(Input input, Tracker tracker) {
        String name = input.ask("Please, input task's name: ");
        String descr = input.ask("enter description: ");
        long time = System.currentTimeMillis();
        Item item = new Item(name, descr, time);
        tracker.add(item);
        System.out.println("Done adding item.");
    }


    private void showAllItems(Tracker tracker) {
        Item[] items = tracker.getAll();
        if(items.length != 0 ) {
            System.out.println("List of items in Tracker:");
            for(int index = 0; index < items.length; index++) {
                System.out.println(index + ". " + items[index].getName() + "; " + items[index].getDescription() + "; id="
                        + items[index].getId() + "; time=" + items[index].creationTime);
            }
        } else System.out.println("No items found!");

    }


    private void editItem(Input input, Tracker tracker) {
        String selectedItem = input.ask("Enter the number of item to edit: ");
        Integer id = null;
        try {
            id = Integer.parseInt(selectedItem);    // type convertion
        } catch (Exception e) {
            System.out.println("* An error occurred");
        }
        Item[] items = tracker.getAll();
        if(id != null && id >=0 && id <= items.length -1 ) {
            String nativeId = items[id].getId();
            String name = input.ask("Please, enter new task's name: ");
            String descr = input.ask("Please, enter new description for the item: ");
            long time = System.currentTimeMillis();
            Item item = new Item(name, descr, time);
            item.setId(nativeId);
            tracker.update(item);
            System.out.println("Done updating item.");
        } else {
            System.out.println("No such item found!");
        }
    }


    private void deleteItem(Input input, Tracker tracker) {
        String selectedItem = input.ask("Enter the number of item to delete: ");
        Integer id = null;
        try {
            id = Integer.parseInt(selectedItem);    // type convertion
        } catch (Exception e) {
            System.out.println("* An error occurred");
        }
        Item[] items = tracker.getAll();
        if(id != null && id >=0 && id <= items.length -1 ) {
            tracker.delete(items[id]);
            System.out.println("Done deleting item.");
        } else {
            System.out.println("No such item found!");
        }
    }


    private void findById(Input input, Tracker tracker) {
        String selectedItem = input.ask("Enter ID of the wanted item: ");
        Item foundItem = null;
        try {
            foundItem = tracker.findById(selectedItem);
        } catch (Exception e) {
            System.out.println("* An error occurred");
        }
        if(foundItem != null) {
            System.out.println("Found item:");
            System.out.println("name=" + foundItem.getName() + "; description=" + foundItem.getDescription() + "; id="
                    + foundItem.getId() + "; time=" + foundItem.creationTime);
        } else {
            System.out.println("No such ID found!");
        }
    }


    private void findByName (Input input, Tracker tracker) {
        String selectedItem = input.ask("Enter the name of the item: ");
        /**
         * we MUST init foundItems before try-catch but we don't know its size
         */
        if(!"".equals(selectedItem)) {
            ArrayList<Item> foundItems;
            try {
                foundItems = new ArrayList<>(Arrays.asList(tracker.findByName(selectedItem)));
                if(foundItems.size() != 0) {

                    System.out.println("List of found items:");
                    for(int i=0; i<foundItems.size(); i++) {
                        System.out.println(foundItems.get(i));
                    }
                } else {
                    System.out.println("No item with such name found!");
                }

            } catch (Exception e) {
                System.out.println("* An error occurred");
            }
        } else {
            System.out.println("Input error!");
        }
    }


    public void init() {

        Tracker tracker = new Tracker();

        String selected;
        boolean exitPressed = false;
        /**
         * бесконечный цикл c выводом списка
         * выход в основной код по Exit
         */
        while (true) {

            selected = input.ask(options);

            switch (selected) {
                case "0":
                    System.out.println("Add new Item selected.");
                    this.createItem(input, tracker);
                    break;
                case "1":
                    System.out.println("Show all items selected");
                    this.showAllItems(tracker);
                    break;
                case "2":
                    System.out.println("Edit item selected");
                    this.editItem(input, tracker);
                    break;
                case "3":
                    System.out.println("Delete item selected");
                    this.deleteItem(input, tracker);
                    break;
                case "4":
                    System.out.println("Find item by Id selected");
                    this.findById(input, tracker);
                    break;
                case "5":
                    System.out.println("Find items by name selected");
                    this.findByName(input, tracker);
                    break;
                case "6":
                    exitPressed = true;
                    break;
                default:
                    System.out.println("incorrect input, try again");
                    // the default case requires no break statement.
            }

            if(exitPressed) break;  // exit from loop
        }



    }   //  init()


    /**
     * main будет. это точка входа программы.
     * здесь не используем ничего, что может нам помешать логике тестов (!)
     * @param args
     */
    public static void main(String[] args) {
        /**
         приветствие должно печататься только один раз
         */
        System.out.println("Welcome! \n" +
                "This is a Tracker program. \n" +
                "It recievs and manipulates tasks and bugs."
        );

        /**
         * используем заглушку
         */
//        Input input = new StubInput(new String[] {"created by Stub", "next elem"});
        /**
         * используем консольный ввод
         */
        Input input = new ConsoleInput();

        /**
         * Start
         */
        new StartUI(input).init();



    }

}
