package start;

public interface Input {
    /**
    как я понимаю, смыл интерфейсов в том, чтобы далее
    использовать _разные_ реализованные от них объекты в одном и том же участке кода
     */
    String ask(String question);
}
