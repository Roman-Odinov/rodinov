package ru.job4j;

/**
 * class Calculate : задачи к Части 001.
 */
public class Calculate {
    /**
     * echo : метод для тестирования.
     *
     * @param value : строка для вывода в консоль
     * @return String value
     */
    public String echo(String value) {
        /*if (value.equals("")) {
			value = "the string is empty!";
		} else {
			value = String.format("%s", value);
		}*/
        return String.format("%s", value);
    }

    /**
     * Конструктор : передача строки и получение результатов.
     *
     * @param args - args
     */
    public static void main(String[] args) {
        Calculate calc = new Calculate();
        // System.out.println(calc.echo(""));	// empty string test
        System.out.println(calc.echo("Hello World"));

    }
}