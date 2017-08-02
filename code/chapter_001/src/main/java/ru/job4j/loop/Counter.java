package ru.job4j.loop;

public class Counter {
    /**
     * Метод должен вычислять сумму _четныx_ чисел в диапазоне от start до finish.
     * Пример:
     * Для диапазона значений от 1 до 10, метод add должен вернуть сумму чётных чисел, равную 30 (2 + 4 + 6 + 8 + 10).
     */
    public int add(int start, int finish) {

        int sum = 0;

        if (start % 2 != 0) { // если это нечетное число, приводим к четному
            start++;
        }

        for (int x = start; x <= finish; x = x + 2) {
            sum = sum + x;
        }
        return sum;
    }
}