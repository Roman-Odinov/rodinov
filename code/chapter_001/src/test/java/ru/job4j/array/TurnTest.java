package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Тесты для метода back класса Turn.
 */
public class TurnTest {
    @Test
    public void TurnTest(){
        // для четного количества элементов
        int[] intArray = { 1, 2, 4, 6, 8, 10, 11, 12 };
        int[] resultArray = new Turn().back(intArray);
        int[] expectArray = { 12, 11, 10, 8, 6, 4, 2, 1 };
        assertThat(resultArray, is(expectArray));

        // для нечетного количества элементов
        intArray = new int[]{ 2, 4, 6, 8, 10 };
        resultArray = new Turn().back(intArray);
        expectArray = new int[]{ 10, 8, 6, 4, 2 };
        assertThat(resultArray, is(expectArray));
    }


}
