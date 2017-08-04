package ru.job4j.array;

/**
 * поворот квадратного массива.
 */
public class RotateArray {

    public int[][] rotate(int[][] intArray) {
        int arrSize = intArray.length;

        int[][] array = new int[arrSize][arrSize];

        for(int i = 0; i < arrSize; ++i) {
            for(int j = 0; j < arrSize; ++j) {
                array[i][j] = intArray[arrSize - j - 1][i];
            }
        }
        return array;
    }

}
