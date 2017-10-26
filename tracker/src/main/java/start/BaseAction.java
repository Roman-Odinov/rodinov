package start;

/**
 * Абстрактный класс, от которого наследуются все события
 * Наследует интерфейс UserAction,
 * реализует метод printInfo(), для исключения дублирования кода в событиях.
 */
public abstract class BaseAction implements UserAction {

    String name;
    int key;

    /**
     * Конструктор.
     * @param key - ключ, по которому активируется событие;
     * @param name - описание события.
     */
    BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * Вывод на печать ключа и описания.
     * @return
     */
    public String printInfo() {
        return String.format("[%s] %s", this.key, this.name);

    }

}
