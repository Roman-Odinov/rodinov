package start;


import helpers.Messages;
import input.Input;
import input.ValidateInput;

/**
 * В консоли отображается приветствие и описание программы.
 * После этого пользователю отображается консольное меню: Список всех действий, которые поддерживаются в системе.
 * Пользователю предлагается выбирать действие, которое он хочет совершить.
 * Когда действие закончено, пользователю опять отображается меню.
 *
 * При запуске класса StartUI пользователю отображается следующее меню:
 0. Show all items
 1. Add new Item
 2. Edit item
 3. Delete item
 4. Find item by Id
 5. Find items by name
 6. Exit Program
 Select:
 *
 */
public class StartUI {

    private Input _input;
    private Tracker _tracker;

    /**
     * Конструктор, применяющий класс ввода данных.
     * @param input - тип Input
     */
    public StartUI(Input input, Tracker tracker) {
        this._input = input;
        this._tracker = tracker;
    }


    public void init() {

        int selected;

        int[] ranges = new int[] {
                Menu._SHOW_ALL_ITEMS_INDEX,
                Menu._CREATE_ITEM_INDEX,
                Menu._EDIT_ITEM_INDEX,
                Menu._DELETE_ITEM_INDEX,
                Menu._FIND_BY_ID_INDEX,
                Menu._FIND_BY_NAME_INDEX,
                Menu._EXIT_INDEX };

        Menu menu = new Menu(_input, _tracker);
        do {
            System.out.println("\nAvailable options:");
            menu.showActions();
            selected = _input.ask("Please select:", ranges);    // get user choise
            menu.select(selected);                                      // invoke selected method
        } while ((selected) != Menu._EXIT_INDEX);
    }


    /**
     * точка входа программы.
     * здесь не используем ничего, что может нам помешать логике тестов
     * @param args
     */
    public static void main(String[] args) {

        Tracker tracker = new Tracker();
        Messages.greeting();

//        Input input = new ConsoleInput();

        Input input = new ValidateInput();

        /**
         * Start
         */
        new StartUI(input, tracker).init();

        System.out.println("Program terminated");


    }

}
