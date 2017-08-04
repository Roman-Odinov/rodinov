package ru.job4j.array;

import java.util.Arrays;

public class ArrayDuplicate {

    /**
     * Сдвиг массива начиная с позиции index
     * @param arr - изменяемый массив
     * @param index - начальная позиция
     */
    private void shift(String[] arr, int index) {
        int arrSize = arr.length;     //! повторюшка, надо проверить
        String temp = arr[index];       // найденный дубликат
        System.arraycopy(arr, index + 1, arr, index, arrSize - 2 + 1 - index);
        arr[arrSize - 1] = temp;        // преносим в конец найденный дубликат
    }


    /**
     * Метод remove - убрать все дубликаты строк из массива.
     * нельзя использовать дополнительные массивы;
     * Для обрезания массива надо использовать Arrays.copyOf метод;
     * @param array - входной массив;
     * @return - итоговый массив.
     */
    public String[] remove(String[] array) {

        // Перед обрезкой массива необходимо сгруппировать дубликаты в конце массива с помощью перестановок.
        int arrSize = array.length;
        int count = 0; // колво найденных дубликатов

        // для каждого элемента с начала массива исключая уже найденное кол-во повторов count
        for(int j = 0; j <= (arrSize - count -2); j++) {
            String cursor = array[j];
            // проходимся по всем следующим, исключая уже найденное кол-во повторов count:
            for(int i = j + 1; i <= (arrSize - count -1); i++) {
                if (cursor.equals(array[i])) {  // если нашли повторение
                    count++;
                    new ArrayDuplicate().shift(array, i);
                }
            }
        }
        return Arrays.copyOf(array, arrSize - count);
    }
}
