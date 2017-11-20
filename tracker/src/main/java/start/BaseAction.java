package start;

import input.Input;

/**
 * Абстрактный класс, от которого наследуются все события.
 * Наследует интерфейс UserAction,
 * реализует метод printInfo(), для исключения дублирования кода в событиях.
 */
public abstract class BaseAction implements UserAction {

    String description;
    int key;

    /**
     * Конструктор.
     *
     * @param key         - ключ, по которому активируется действие;
     * @param description - описание действия.
     */
    BaseAction(int key, String description) {
        this.key = key;
        this.description = description;
    }

    /**
     * Возвращает подсказку: ключ - описание действия.
     *
     * @return String
     */
    public String printInfo() {
        return String.format("[%s] %s", this.key, this.description);
    }


    /**
     * Исполнение действия для события
     *
     * @param input
     * @param tracker
     */
    public abstract void execute(Input input, Tracker tracker);


}
