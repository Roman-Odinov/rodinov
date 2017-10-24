package start;

import models.Item;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Написать класс Menu который будет реализовывать меню.
 * В классе Menu реализовать внутренние классы событий.
 * При реализации событий использовать статический внутренний класс, расположенный в одном файле с Menu.
 */


public class Menu {
    private Input input_;
    private Tracker tracker_;
    private UserAction[] actions_ = new UserAction[7];

    public Menu(Input input, Tracker tracker) {
        this.input_ = input;
        this.tracker_ = tracker;
        this.fillActions();
    }

    /**
     * Fill actions array
     */
    private void fillActions() {
        actions_[0] = new showAllItems();
        actions_[1] = new createItem();
        actions_[2] = new EditItem();
        actions_[3] = new deleteItem();
        actions_[4] = new findById();
        actions_[5] = new findByName();
        actions_[6] = new Exit();
    }

    /**
     * Executes selected menu
     * @param key
     */
    public void select(String key) {
        try {
            actions_[Integer.parseInt(key)].execute(input_, tracker_);
        } catch (Exception e) {
            System.out.println("incorrect input, try again");
        }
    }

    /**
     * Prints all available options
     */
    public void showActions() {
        for (UserAction action : actions_) {
            if (action != null) {
                System.out.println(action.printInfo());
            }
        }
    }


    private static class showAllItems implements  UserAction {
        public int key() {
            return 0;
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
            } else System.out.println("No items found!");

        }
    }

    private static class createItem implements  UserAction {
        public int key() {
            return 1;
        }

        public String printInfo() {
            return String.format("[%s] %s", this.key(), "Add new Item");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Add new Item selected.");
            String name = input.ask("Please, input task's name: ");
            if(name.equals("")) {
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

    private static class EditItem implements UserAction {
        public int key(){
            return 2;
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
                System.out.println("* An error occurred. Not a number?");
                return;
            }
            Item[] items = tracker.getAll();
            if( id >=0 && id <= (items.length -1) ) {
                String nativeId = items[id].getId();
                String name = input.ask("Please, enter new task's name: ");
                if(name.equals("")) {
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

    private static class deleteItem implements UserAction {
        public int key() {
            return 3;
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
                System.out.println("* An error occurred. Not a number?");
                return;
            }
            Item[] items = tracker.getAll();
            if( id >=0 && id <= (items.length -1) ) {
                tracker.delete(items[id]);
                System.out.println("Done deleting item.");
            } else {
                System.out.println("No such item found!");
            }
        }
    }

    private static class findById implements UserAction {
        public int key() {
            return 4;
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
    }

    private static class findByName implements UserAction {
        public int key() {
            return 5;
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
            if(!"".equals(selectedItem)) {
                ArrayList<Item> foundItems;
                try {
                    foundItems = new ArrayList<>(Arrays.asList(tracker.findByName(selectedItem)));
                    if(foundItems.size() != 0) {
                        System.out.println("List of found items:");
                        for(Item foundItem : foundItems) {
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

    private static class Exit implements  UserAction {
        public int key() {
            return 6;
        }

        public String printInfo() {
            return String.format("[%s] %s", this.key(), "Exit");
        }

        public void execute(Input input, Tracker tracker) {
            System.out.println("[*] Exit selected");
        }
    }

}   // Menu
