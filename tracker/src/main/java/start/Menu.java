package start;

import input.Input;
import models.Item;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Написать класс Menu который будет реализовывать меню.
 * В классе Menu реализовать внутренние классы событий.
 * При реализации событий использовать статический внутренний класс, расположенный в одном файле с Menu.
 */


public class Menu {

    // available options quantity
    private static final int _USER_ACTIONS_COUNT = 7;

    // menu indices
    public static final int _SHOW_ALL_ITEMS_INDEX = 0;
    public static final int _CREATE_ITEM_INDEX = 1;
    public static final int _EDIT_ITEM_INDEX = 2;
    public static final int _DELETE_ITEM_INDEX = 3;
    public static final int _FIND_BY_ID_INDEX = 4;
    public static final int _FIND_BY_NAME_INDEX = 5;
    public static final int _EXIT_INDEX = 6;

    private Input _input;
    private Tracker _tracker;
    private UserAction[] _actions = new UserAction[_USER_ACTIONS_COUNT];


    public Menu(Input input, Tracker tracker) {
        this._input = input;
        this._tracker = tracker;
        this.fillActions();
    }

    /**
     * Fill actions array.
     */
    private void fillActions() {
        _actions[_SHOW_ALL_ITEMS_INDEX] = new showAllItems();
        _actions[_CREATE_ITEM_INDEX] = new createItem();
        _actions[_EDIT_ITEM_INDEX] = new EditItem();
        _actions[_DELETE_ITEM_INDEX] = new deleteItem();
        _actions[_FIND_BY_ID_INDEX] = new findById();
        _actions[_FIND_BY_NAME_INDEX] = new findByName();
        _actions[_EXIT_INDEX] = new Exit();
    }

    /**
     * Executes selected menu.
     * @param key int
     */
    public void select(int key) {
        _actions[key].execute(_input, _tracker);
    }

    /**
     * Prints all available options.
     */
    public void showActions() {
        for (UserAction action : _actions) {
            if (action != null) {
                System.out.println(action.printInfo());
            }
        }
    }


    private static class showAllItems implements  UserAction {
        public int key() {
            return Menu._SHOW_ALL_ITEMS_INDEX;
        }

        public String printInfo() {
            return String.format("[%s] %s", this.key(), "Show all items");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Show all items selected");
            Item[] items = tracker.getAll();
            if (items.length != 0) {
                System.out.println("List of items in Tracker:");
                for (int index = 0; index < items.length; index++) {
                    System.out.println(index + ". " + items[index].getName() + "; " + items[index].getDescription() + "; id="
                            + items[index].getId() + "; time=" + items[index].creationTime);
                }
            } else {
                System.out.println("No items found!");
            }
        }
    }

    private static class createItem implements  UserAction {
        public int key() {
            return Menu._CREATE_ITEM_INDEX;
        }

        public String printInfo() {
            return String.format("[%s] %s", this.key(), "Add new Item");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Add new Item selected.");
            String name = input.ask("Please, input task's name: ");
            if (name.equals("")) {
                System.err.println("* An error occurred. Empty name.");
                return;
            }
            String descr = input.ask("enter description: ");
            long time = System.currentTimeMillis();
            Item item = new Item(name, descr, time);
            tracker.add(item);
            System.out.println("Done adding item.");
        }
    }

    private static class EditItem implements UserAction {
        public int key() {
            return Menu._EDIT_ITEM_INDEX;
        }

        public String printInfo() {
            return String.format("[%s] %s", this.key(), "Edit item");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Edit item selected");
            String selectedItem = input.ask("Enter the number of item to edit: ");
            Integer id = null;
            try {
                id = Integer.parseInt(selectedItem);    // type convertion
            } catch (Exception e) {
                System.err.println("* An error occurred. Not a number?");
                return;
            }
            Item[] items = tracker.getAll();
            if ( id >= 0 && id <= (items.length - 1) ) {
                String nativeId = items[id].getId();
                String name = input.ask("Please, enter new task's name: ");
                if (name.equals("")) {
                    System.err.println("* An error occurred. Empty name.");
                    return;
                }
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
    }

    private static class deleteItem implements UserAction {
        public int key() {
            return Menu._DELETE_ITEM_INDEX;
        }

        public String printInfo() {
            return String.format("[%s] %s", this.key(), "Delete item");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Delete item selected");
            String selectedItem = input.ask("Enter the number of item to delete: ");
            Integer id = null;
            try {
                id = Integer.parseInt(selectedItem);    // type convertion
            } catch (Exception e) {
                System.err.println("* An error occurred. Not a number?");
                return;
            }
            Item[] items = tracker.getAll();
            if ( id >= 0 && id <= (items.length - 1) ) {
                tracker.delete(items[id]);
                System.out.println("Done deleting item.");
            } else {
                System.out.println("No such item found!");
            }
        }
    }

    private static class findById implements UserAction {
        public int key() {
            return Menu._FIND_BY_ID_INDEX;
        }

        public String printInfo() {
            return String.format("[%s] %s", this.key(), "Find item by Id");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Find item by Id selected");
            String selectedItem = input.ask("Enter the ID to search: ");
            Item foundItem = null;
            try {
                foundItem = tracker.findById(selectedItem);
            } catch (Exception e) {
                System.err.println("* An error occurred");
            }
            if (foundItem != null) {
                System.out.println("Found item:");
                System.out.println("name=" + foundItem.getName() + "; description=" + foundItem.getDescription() + "; id="
                        + foundItem.getId() + "; time=" + foundItem.creationTime);
            } else {
                System.err.println("No such ID found!");
            }
        }
    }

    private static class findByName implements UserAction {
        public int key() {
            return Menu._FIND_BY_NAME_INDEX;
        }

        public String printInfo() {
            return String.format("[%s] %s", this.key(), "Find items by name");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Find items by name selected");
            String selectedItem = input.ask("Enter the name of the item: ");
            /**
             * we MUST init foundItems before try-catch but we don't know its size
             */
            if (!"".equals(selectedItem)) {
                ArrayList<Item> foundItems;
                try {
                    foundItems = new ArrayList<>(Arrays.asList(tracker.findByName(selectedItem)));
                    if (foundItems.size() != 0) {
                        System.out.println("List of found items:");
                        for (Item foundItem : foundItems) {
                            System.out.println("name=" + foundItem.getName() + "; description=" + foundItem.getDescription() + "; id="
                                    + foundItem.getId() + "; time=" + foundItem.creationTime);
                        }
                    } else {
                        System.out.println("No item with such name found!");
                    }

                } catch (Exception e) {
                    System.err.println("* An error occurred");
                }
            } else {
                System.err.println("Input error!");
            }

        }
    }

    private static class Exit implements  UserAction {
        public int key() {
            return Menu._EXIT_INDEX;
        }

        public String printInfo() {
            return String.format("[%s] %s", this.key(), "Exit");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Exit selected");
        }
    }

}   // Menu
