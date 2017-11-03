
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Необходимо создать итератор для двухмерного массива.
 *
 * int[][] value = {
 * {1, 2}
 * {3, 4}
 * };
 *
 * метод next = должен вернуть последовательно 1, 2, 3, 4.
 *
 * Старайтесь написать универсальное решение, чтобы оно не было жестко ориентировано на тестовый пример.
 * И хотя в примере указана квадратная матрица, программа должна корректно обрабатывать и jagged array тоже.
 */
public class MatrixIterator implements Iterator<Integer> {

    private final int[] array;
    private final int len;
    private int index = -1;

    public MatrixIterator(int[][] array) {

        // разложим в одномерный
        int capacity = 0;
        for (int[] ar : array) {
            capacity += ar.length;
        }
        this.array = new int[capacity];
        int index2 = 0;
        for (int[] ar : array) {
            for (int value : ar) {
                this.array[index2++] = value;
            }
        }
        this.len = this.array.length;
    }


    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return index + 1 < len;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Integer next() {
        index++;
        try {
            return array[index];
        } catch (Exception e) {
            throw new NoSuchElementException();
        }
    }

}
