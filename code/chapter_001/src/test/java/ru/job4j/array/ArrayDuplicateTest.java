package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для метода remove() класса ArrayDuplicate.
 */
public class ArrayDuplicateTest {
    @Test
    public void removeTest() throws Exception {
        String[] intArray = {"Привет", "Мир", "Привет", "Супер", "Мир", "Супер", "Привет", "Test"};
        String[] resultArray = new ArrayDuplicate().remove(intArray);
        String[] expectedArray = {"Привет", "Мир", "Супер", "Test"};
        assertThat(resultArray, is(expectedArray));
    }

}