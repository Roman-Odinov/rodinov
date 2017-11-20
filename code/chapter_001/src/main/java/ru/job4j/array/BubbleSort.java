package ru.job4j.array;

/**
 * алгоритм сортировки пузырьком.
 * Метод swap - замена 2-х элементов в массиве;
 * Метод sort - сортировка пузырьковым методом.
 */
public class BubbleSort {

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
     * Сортировка массива целых чисел, используя алгоритм сортировки пузырьком от меньшего к бОльшему.
     *
     * @param intArray - входящий массив;
     * @return - сортированный массив;
     */
    public int[] sort(int[] intArray) {
        int arrSize = intArray.length;
        // делаем копию масива
        int[] array = new int[arrSize];
        System.arraycopy(intArray, 0, array, 0, arrSize);

        for (int j = 0; j < arrSize - 1; j++) {
            boolean flipped = false;
            for (int i = 0; i < arrSize - 1 - j; i++) {
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                    flipped = true;
                }
            }
            if (!flipped) {
                break;
            }
        }
        return array;
    }

    /**
     * Для отладки!
     * @param args
     */
    /*
    public static void main(String[] args) {
        int[] intArr = { 1, 118, 5, 4, 16, 7, 9 };
        int[] sorted = new BubbleSort().sort(intArr);
        System.out.println(intArr);
        System.out.println(sorted);
        System.out.println(Arrays.toString(intArr));
        System.out.println(Arrays.toString(sorted));
    }
    */
}
