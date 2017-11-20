package ru.job4j.array;

import java.util.Arrays;

/**
 * Класс Turn пакета Arrays.
 * Метод swap - замена 2-х элементов в массиве;
 * Метод back: перевернуть массив задом наперёд.
 */
public class Turn {

    /**
     * Метод swap - замена 2-х элементов в массиве.
     *
     * @param i   - индекс одного элемента
     * @param j   - индекс второго элемента
     * @param arr - массив.
     */
    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Метод back: перевернуть массив задом наперёд.
     *
     * @param intArray - входной массив;
     * @return - возвращает перевернутую задом наперёд _копию_ массива.
     */
    public int[] back(int[] intArray) {
        int arrSize = intArray.length;
        // делаем копию масива
        int[] array = new int[arrSize];
        System.arraycopy(intArray, 0, array, 0, arrSize);
        // делаем своп элементов с двух сторон
        int loopLimit = Math.round(arrSize / 2);
        for (int count = 0; count < loopLimit; count++) {
            swap(count, (arrSize - 1) - count, array);
        }
        return array;
    }

    /**
     * Наглядные тесты.
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] intArray = { 6, 8, 10 };
//        int[] intArray = { 4, 6, 8, 10 };
        int[] intArray = {2, 4, 6, 8, 10};
//        int[] intArray = { 2, 4, 6, 8, 10, 11 };
//        int[] intArray = { 1, 2, 4, 6, 8, 10, 11, 12 };
        int[] backArray = new Turn().back(intArray);
        System.out.println(Arrays.toString(intArray));
        System.out.println(Arrays.toString(backArray));
    }
}
