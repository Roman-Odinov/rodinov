package start;

import input.Input;
import models.Item;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Реализация меню пользователя.
 * В классе реализованы статические внутренние классы событий.
 */
public class Menu {

    // available options quantity
    private static final int USER_ACTIONS_COUNT = 7;

    // menu indices
    public static final int SHOW_ALL_ITEMS_INDEX = 0;
    public static final int CREATE_ITEM_INDEX = 1;
    public static final int EDIT_ITEM_INDEX = 2;
    public static final int DELETE_ITEM_INDEX = 3;
    public static final int FIND_BY_ID_INDEX = 4;
    public static final int FIND_BY_NAME_INDEX = 5;
    public static final int EXIT_INDEX = 6;

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[USER_ACTIONS_COUNT];

    public Menu(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.fillActions();
    }

    /**
     * Fill actions array.
     */
    private void fillActions() {
        actions[SHOW_ALL_ITEMS_INDEX] = new showAllItems(SHOW_ALL_ITEMS_INDEX, "Show all items");
        actions[CREATE_ITEM_INDEX] = new createItem(CREATE_ITEM_INDEX, "Add new Item");
        actions[EDIT_ITEM_INDEX] = new EditItem(EDIT_ITEM_INDEX, "Edit item");
        actions[DELETE_ITEM_INDEX] = new deleteItem(DELETE_ITEM_INDEX, "Delete item");
        actions[FIND_BY_ID_INDEX] = new findById(FIND_BY_ID_INDEX, "Find item by Id");
        actions[FIND_BY_NAME_INDEX] = new findByName(FIND_BY_NAME_INDEX, "Find items by name");
        actions[EXIT_INDEX] = new Exit(EXIT_INDEX, "Exit");
    }

    /**
     * Executes selected menu.
     *
     * @param key int
     */
    public void select(int key) {
        actions[key].execute(input, tracker);
    }

    /**
     * Prints all available options.
     */
    public void showActions() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.printInfo());
            }
        }
    }


    private static class showAllItems extends BaseAction {

        // call BaseAction Constructor
        showAllItems(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Show all items selected");
            Item[] items = tracker.getAll();    ////todo type
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

    private static class createItem extends BaseAction {

        createItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Add new Item selected.");
            String name = input.ask("Please, input task's name: ");
            if (name.equals("")) {
                System.out.println("* An error occurred. Empty name.");
                return;
            }
            String descr = input.ask("enter description: ");
            long time = System.currentTimeMillis();
            Item item = new Item(name, descr, time);
            tracker.add(item);
            System.out.println("Done adding item.");
        }
    }

    private static class EditItem extends BaseAction {

        EditItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Edit item selected");
            String selectedItem = input.ask("Enter the number of item to edit: ");
            Integer id = null;
            try {
                id = Integer.parseInt(selectedItem);    // type convertion
            } catch (Exception e) {
                System.out.println("* An error occurred. Not a number?");
                return;
            }
            Item[] items = tracker.getAll();    //todo type
            if (id >= 0 && id <= (items.length - 1)) {
                String nativeId = items[id].getId();
                String name = input.ask("Please, enter new task's name: ");
                if (name.equals("")) {
                    System.out.println("* An error occurred. Empty name.");
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

    private static class deleteItem extends BaseAction {

        deleteItem(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Delete item selected");
            String selectedItem = input.ask("Enter the number of item to delete: ");
            Integer id = null;
            try {
                id = Integer.parseInt(selectedItem);    // type convertion
            } catch (Exception e) {
                System.out.println("* An error occurred. Not a number?");
                return;
            }
            Item[] items = tracker.getAll();    //todo type
            if (id >= 0 && id <= (items.length - 1)) {
                tracker.delete(items[id]);
                System.out.println("Done deleting item.");
            } else {
                System.out.println("No such item found!");
            }
        }
    }

    private static class findById extends BaseAction {

        findById(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Find item by Id selected");
            String selectedItem = input.ask("Enter the ID to search: ");
            Item foundItem = null;
            try {
                foundItem = tracker.findById(selectedItem);
            } catch (Exception e) {
                System.out.println("* An error occurred");
            }
            if (foundItem != null) {
                System.out.println("Found item:");
                System.out.println("name=" + foundItem.getName() + "; description=" + foundItem.getDescription() + "; id="
                        + foundItem.getId() + "; time=" + foundItem.creationTime);
            } else {
                System.out.println("No such ID found!");
            }
        }
    }

    private static class findByName extends BaseAction {

        findByName(int key, String name) {
            super(key, name);
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
                    foundItems = new ArrayList<>(Arrays.asList(tracker.findByName(selectedItem)));  //todo
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
                    System.out.println("* An error occurred");
                }
            } else {
                System.out.println("Input error!");
            }

        }
    }

    private static class Exit extends BaseAction {

        Exit(int key, String name) {
            super(key, name);
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Exit selected");
        }
    }

}   // Menu
