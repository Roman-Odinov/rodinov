package start;


import input.Input;
import input.ValidateInput;

import java.util.ArrayList;

/**
 * В консоли отображается приветствие и описание программы.
 * После этого пользователю отображается консольное меню: Список всех действий, которые поддерживаются в системе.
 * Пользователю предлагается выбирать действие, которое он хочет совершить.
 * Когда действие закончено, пользователю опять отображается меню.
 *
 * При запуске класса StartUI пользователю отображается следующее меню:
 * 0. Show all items
 * 1. Add new Item
 * 2. Edit item
 * 3. Delete item
 * 4. Find item by Id
 * 5. Find items by name
 * 6. Exit Program
 * Please select:
 */
public class StartUI {

    private Input _input;
    private Tracker _tracker;

    /**
     * Конструктор, применяющий класс ввода данных.
     *
     * @param input - тип Input
     */
    public StartUI(Input input, Tracker tracker) {
        this._input = input;
        this._tracker = tracker;
    }


    public void init() {

        int selected;

        // fill allowable range to select
        int[] ranges = new int[]{
                Menu.SHOW_ALL_ITEMS_INDEX,
                Menu.CREATE_ITEM_INDEX,
                Menu.EDIT_ITEM_INDEX,
                Menu.DELETE_ITEM_INDEX,
                Menu.FIND_BY_ID_INDEX,
                Menu.FIND_BY_NAME_INDEX,
                Menu.EXIT_INDEX};

//        ArrayList<Integer> ranges = new ArrayList<>();
//        ranges.add(Menu.SHOW_ALL_ITEMS_INDEX);
//        ranges.add(Menu.CREATE_ITEM_INDEX);
//        ranges.add(Menu.EDIT_ITEM_INDEX);
//        ranges.add(Menu.DELETE_ITEM_INDEX);
//        ranges.add(Menu.FIND_BY_ID_INDEX);
//        ranges.add(Menu.FIND_BY_NAME_INDEX);
//        ranges.add(Menu.EXIT_INDEX);

        Menu menu = new Menu(_input, _tracker);

        // show menu and get user's choise
        do {
            System.out.println("\nAvailable options:");
            menu.showActions();                                         // show allowable actions
            selected = _input.ask("Please select:", ranges);    // get user choise
            menu.select(selected);                                      // invoke selected method
        } while ((selected) != Menu.EXIT_INDEX);
    }


    /**
     * Точка входа программы.
     * Здесь не используем ничего, что может нам помешать логике тестов
     *
     * @param args
     */
    public static void main(String[] args) {

        Tracker tracker = new Tracker();

        System.out.println("Welcome! \n"
                + "This is a Tracker program. \n"
                + "It recievs and manipulates tasks and bugs.");

        Input input = new ValidateInput();      // ввод с валидацией данных

        /**
         * Start
         */
        new StartUI(input, tracker).init();

        System.out.println("Program terminated");


    }

}
