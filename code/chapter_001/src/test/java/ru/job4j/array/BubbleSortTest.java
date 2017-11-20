package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты для метода back класса BubbleSort.
 */
public class BubbleSortTest {
    @Test
    public void sortTest() throws Exception {
        int[] intArray = {1, 118, 5, 4, 16, 7, 9};
        int[] resultArray = new BubbleSort().sort(intArray);
        int[] expectedArray = {1, 4, 5, 7, 9, 16, 118};
        assertThat(resultArray, is(expectedArray));
    }

}