package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Создать итератор возвращающий только четные цифры.
 * Итератор должен принимать список произвольных чисел.
 *
 * public EvenIt(final int[] numbers) {
 *
 * Iterator it = new EventIt(new int[]  {4, 2, 1, 1});
 *
 * методы
 * it.next() - возвращают только четные числа. В этом примере - это 4 и 2.
 * it.hasNext() - возвращает true, только если в массиве есть четные перед указателем.
 *
 * Например. если мы дернем два раза метод next, то указатель сместить на второй элемент.
 * При вызове метода hasNext - он вернет false. так как после указателя больше нет четных чисел.
 */
public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] array;
    private final int len;
    private int index = -1;
    private int evenIndex;

    public EvenNumbersIterator(int[] array) {
        this.array = array;
        this.len = array.length;
    }

    /**
     * возвращает true, только если в массиве есть четные перед указателем.
     *
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        boolean has = false;
        for (int i = index + 1; i < len; i++) {
            if (0 == array[i] % 2) {
                has = true;
                evenIndex = i;
                break;
            }
        }
        return has;
    }

    /**
     * it.next() - возвращают только четные числа.
     * метод next в случае отсутствия элементов к возврату генерирует NoSuchElementException.
     * метод next должен возвращать верные значения вне зависимости от того вызвал ли перед этим программист метод hasNext.
     * Аналогично для hasNext.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Integer next() throws NoSuchElementException {
        if (hasNext()) {
            index = evenIndex;
            return array[index];
        }
        throw new NoSuchElementException();
    }
}
