package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.lang.StrictMath.sqrt;

/**
 * Создать итератор возвращающий только простые числа.
 * Простым является натуральное число больше 1, которое делится без остатка только на 1 и на себя.
 *
 * Итератор должен принимать список произвольных чисел.
 *
 * public PrimeIt(final int[] numbers) {
 *
 * Iterator it = new PrimetIt(new int[] {3, 4, 5, 6, 7});
 *
 * методы
 *
 * it.next() - возвращают только простые числа. В этом примере - это 3, 5 и 7.
 *
 * it.hasNext() - возвращает true, только если в массиве есть простые числа перед указателем.
 *
 * Последовательность простых чисел начинается так: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
 * 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199 …
 */
public class PrimeIterator implements Iterator {

    private final int[] array;
    private final int len;
    private int index = -1;
    private int primeIndex;

    public PrimeIterator(int[] arr) {
        this.array = arr;
        this.len = array.length;
    }

    /**
     * возвращает true, только если в массиве есть простые числа после указателя.
     *
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        // не выкидывать false пока не дойдем до конца
        boolean has = false;
        int value;

        // здесь проверяем КАЖДЫЙ элемент правее
        for (int i = index + 1; i < len; i++) {
            // текущий элемент
            value = array[i];
            // 2 и 3 не пройдут по вложенному циклу, так что не будет установки флага true
            // (1 тоже не пройдет, но он не prime, дефолтное false )
            if (value == 2 || value == 3) {
                has = true;
                primeIndex = i;
            }
            // ПРОВЕРЯЕМ ЯВЛЯЕТСЯ ЛИ value ПРОСТЫМ ЧИСЛОМ
            double s = sqrt(value);
            for (int j = 2; j <= s; j++) {
                has = true;
                if (value % j == 0) {   // value is not prime
                    has = false;
                    break;
                }
                // если мы вышли сюда - это может быть как value is not prime так и value is prime
            }
            if (has) {
                primeIndex = i;
                return has;
            }
            // проверяем следующий элемент
        }
        return has;
    }

    /**
     * возвращает простое число, если таковое есть в массиве после указателя.
     *
     * @return Integer
     * @throws NoSuchElementException
     */
    @Override
    public Integer next() throws NoSuchElementException {

        if (hasNext()) {
            index = primeIndex;
            return array[index];
        }
        // ничего не найдено
        throw new NoSuchElementException();
    }

}
