package start;


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

    /**
     * Принимаем все объекты, реализованные от интерфейса Input
     */
    private Input input_;
    private Tracker tracker_;

    /**
     * Пустой конструктор для вспомогательных методов
     */
//    public StartUI(){}

    /**
     * Конструктор, применяющий класс ввода данных
     * @param input - тип Input
     */
    public StartUI(Input input, Tracker tracker) {
        this.input_ = input;
        this.tracker_ = tracker;
    }


    public void init() {
        String selected;
        Menu menu = new Menu(input_, tracker_);

        do {
            System.out.println("\nAvailable options:");
            menu.showActions();
            selected = input_.ask("Please select:");
            menu.select(selected);
        } while (!"6".equals(selected));    // TODO: no hardcode


    }


    /**
     * точка входа программы.
     * здесь не используем ничего, что может нам помешать логике тестов
     * @param args
     */
    public static void main(String[] args) {

        Tracker tracker = new Tracker();

        /**
         * приветствие
         */
        System.out.println("Welcome! \n" +
                "This is a Tracker program. \n" +
                "It recievs and manipulates tasks and bugs."
        );

        /**
         * используем консольный ввод
         */
        Input input = new ConsoleInput();

        /**
         * Start
         */
        new StartUI(input, tracker).init();

        System.out.println("Program terminated");


    }

}
