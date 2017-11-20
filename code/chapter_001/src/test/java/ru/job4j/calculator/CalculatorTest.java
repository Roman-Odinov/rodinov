package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class CalculatorTest - тесты методов класса Calculator.
 */
public class CalculatorTest {
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void testSubstract() {
        Calculator calc = new Calculator();
        calc.substract(10D, 8D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void testDiv() {
        Calculator calc = new Calculator();
        calc.div(35D, 7D);
        double result = calc.getResult();
        double expected = 5D;
        assertThat(result, is(expected));
    }

    @Test
    public void testMultiply() {
        Calculator calc = new Calculator();
        calc.multiply(10D, 8D);
        double result = calc.getResult();
        double expected = 80D;
        assertThat(result, is(expected));
    }
}