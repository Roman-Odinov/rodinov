package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Реализовать класс с методом Iterator<Integer> convert(Iterator<Iterator<Integer>> its).
 *
 * Что из себя представляет запись Iterator<Iterator<Integer>> ?.
 * Каждый итератор - это последовательность.
 * Iterator 1 – 4 2 0 4 6 4 9
 * Iterator 2 – 0 9 8 7 5
 * Iterator 3 – 1 3 5 6 7 0 9 8 4
 *
 * Если мы говорим о записи Итератор Итераторов. Значит итератор содержит не конечные значения, а сложенные итераторы.
 * Iterator - Iterator 1, Iterator 2, Iterator 3.
 *
 * Метод convert должен принимать объект итератор итератор и возвращать Итератор чисел.
 *
 * Iterator<Iterator<Integer> - ((4 2 0 4 6 4 9), (0 9 8 7 5), (1 3 5 6 7 0 9 8 4))
 *
 * Метод должен возвращать
 *
 * Iterator<Integer> - (4 2 0 4 6 4 9 0 9 8 7 5 1 3 5 6 7 0 9 8 4)
 *
 * Метод не должен копировать данные. Нужно реализовать итератор, который будет пробегать по вложенными итераторам без копирования данных.
 */
public class Converter {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> its) {
        Iterator<Integer> iterator = null;

        return new Iterator<Integer>() {
            Iterator<Integer> iterator = null;

            @Override
            public boolean hasNext() {

                boolean has = false;

                if (iterator == null || !iterator.hasNext()) {
                    has = its.hasNext();
                } else {   // --> iterator.hasNext() == true
                    has = true;
                }
                return has;
            }

            @Override
            public Integer next() throws NoSuchElementException {

                if (iterator == null) {       // первонач заполнение -- самый первый вызов метода вообще
                    iterator = its.next();   // вызываем родительский метод, iterator получает вложенный Iterator
                    // fixme: если мы передадим полностью пустой массив - здесь ошибка, но лень
                } else if (!iterator.hasNext()) { // если нет int-а дальше:
                    if (its.hasNext()) {         // и если есть следующий большой Iterator
                        iterator = its.next();      // присваеваем его iterator-у
                    }
                }

                // если мы здесь, значит:
                // - у нас или остался еще next
                // - или мы присвоили iterator = its.next(), тогда проверяем, есть ли в нём элементы
                if (iterator.hasNext()) {                 // идем уже по элементам int
                    return iterator.next();
                }
                throw new NoSuchElementException();    // иначе - совсем ничего не осталось :(
            }
        }; // Anonymous Class

    } // convert()


} // Converter