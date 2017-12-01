package ru.job4j.loop;

public class Factorial {
    /**
     * Расчет факториала.
     *
     * @param n - входящее положительное целое;
     * @return int факториал для этого числа;
     */
    public int calc(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }
}
