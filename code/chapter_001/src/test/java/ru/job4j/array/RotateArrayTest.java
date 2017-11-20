package ru.job4j.array;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса RotateArray.
 */
public class RotateArrayTest {
    @Test
    public void rotateTest() throws Exception {
        int[][] intArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(intArray));
        int[][] resultArray = new RotateArray().rotate(intArray);
        System.out.println(Arrays.deepToString(resultArray));
        int[][] expectedArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(resultArray, is(expectedArray));

        intArray = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 0, 1, 2},
                {3, 4, 5, 6}
        };
        System.out.println(Arrays.deepToString(intArray));
        resultArray = new RotateArray().rotate(intArray);
        System.out.println(Arrays.deepToString(resultArray));
        expectedArray = new int[][]{{3, 9, 5, 1}, {4, 0, 6, 2}, {5, 1, 7, 3}, {6, 2, 8, 4}};
        assertThat(resultArray, is(expectedArray));

    }

}