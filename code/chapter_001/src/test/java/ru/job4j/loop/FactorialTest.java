package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * В классе FactorialTest напишите 2 тест-метода, которые будет проверять вашу программу.
 * Факториал для числа 5 будет равен 120 (1 * 2 * 3 * 4 * 5).
 * Факториал для числа 0 равен 1
 */
public class FactorialTest {
    @Test
    public void calc() throws Exception {
        int expectedValue = 0;
        Factorial factorial = new Factorial();
        int actualValue = factorial.calc(0);
        assertEquals(expectedValue, actualValue);

        expectedValue = 120;
        actualValue = factorial.calc(5);
        assertEquals(expectedValue, actualValue);
    }

}