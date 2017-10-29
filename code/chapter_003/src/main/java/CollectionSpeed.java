import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Написать программу, которая замеряет время
 * (1) вставки в коллекцию большого количества случайных строк и
 * (2) удаления в коллекции первых n элементов для:
 * LinkedList
 * ArrayList
 * TreeSet
 *
 * В классе должно быть 2 метода:
 * public long add(Collection<String> collection, int amount) {}
 * public long delete(Collection<String> collection, int amount) {}
 *
 * По результатам тестов расставьте коллекции по местам и объясните результат.
 *
 * Примечание: так как эти 3 коллекции имеют одинаковый интерфейс Collection мы можем использовать
 * методы add и remove для всех них.
 */
public class CollectionSpeed {

    static final SecureRandom RND = new SecureRandom();
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static final int LENGTH = AB.length();
    static long delayTime;          // временные задержки, не относящиеся напрямую к добавлению/удалению элементов


    /**
     * Random string generator.
     *
     * @param len length of the string
     * @return string
     */
    static String randomString(int len) {
        long startTime = System.nanoTime();

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(RND.nextInt(LENGTH)));
        String sb_toString = sb.toString();

        long stopTime = System.nanoTime();
        delayTime += (stopTime - startTime);    // учитываем тут задержку на вызовы данного метода

        return sb_toString;
    }

    /**
     * Fill collection with amount of random Strings.
     *
     * @param collection java.util.Collection
     * @param amount     how many elements to insert
     * @return spended time
     */
    public long add(Collection<String> collection, int amount) {

        delayTime = 0; // обнуляем для каждого вызова метода

//        System.out.println("--------- add module ---------");
//        System.out.println("collection.size BEFORE " + collection.size());

        int minLineLength = 5;  // минимальная длина генерируемой строки
        int maxLineLength = 10; // максимальная длина

        long startTime = System.nanoTime();

        for (int i = 0; i < amount; i++) {
            collection.add(randomString(
                    /* generate random int in range(minLineLength, maxLineLength + 1) */
                    ThreadLocalRandom.current().nextInt(minLineLength, maxLineLength + 1)
            ));
        }

        long stopTime = System.nanoTime();

//        System.out.println("collection.size AFTER " + collection.size());
//        System.out.printf("delayTime spended in randomString() = %s ns / %s ms%n", delayTime, delayTime / 1000000);

        return (stopTime - startTime) - delayTime;
    }

    /**
     * Delete first amount of elements in collection.
     *
     * @param collection java.util.Collection
     * @param amount     how many elements to delete
     * @return spended time
     */
    public long delete(Collection<String> collection, int amount) {

        if (amount == 0) return 0;
        int i = 0;

//        System.out.println("--------- delete module ---------");
//        System.out.println("collection.size before " + collection.size());

        long startTime = System.nanoTime();

        for (Iterator<String> iter = collection.iterator(); iter.hasNext(); ) {
            if (i++ >= amount) {
                break;
            }
            iter.next();
            iter.remove();
        }

        long stopTime = System.nanoTime();

//        System.out.println("collection.size after " + collection.size());

        return (stopTime - startTime);
    }

    public void TEST(String name, Collection<String> collection, int amout) {

        long spentTime;

        spentTime = add(collection, amout);
        System.out.printf("<%s> ADD %d elements = %s ns / %s ms%n", name, amout, spentTime, spentTime / 1000000);

        System.out.println();
        spentTime = delete(collection, amout);
        System.out.printf("<%s> DELETE %d elements = %s ns / %s ms%n%n", name, amout, spentTime, spentTime / 1000000);
        System.out.println("______________________________________________________________");

    }

    public static void main(String[] args) {

//        final int MIN_AMOUNT_OF_ELEMS = 999;
//        final int MIDDLE_AMOUNT_OF_ELEMS = 9999;
        final int MAX_AMOUNT_OF_ELEMS = 99999;

//        final int MIN_DELETE_ELEMS = MIN_AMOUNT_OF_ELEMS / 2;
//        final int MIDDLE_DELETE_ELEMS = MIDDLE_AMOUNT_OF_ELEMS / 2;
//        final int MAX_DELETE_ELEMS = MAX_AMOUNT_OF_ELEMS / 2;

        CollectionSpeed cs = new CollectionSpeed();
        long spentTime;

        Collection<String> collection;

        collection = new LinkedList<>();
        cs.TEST("LinkedList", collection, MAX_AMOUNT_OF_ELEMS);
        collection = new ArrayList<>();
        cs.TEST("ArrayList", collection, MAX_AMOUNT_OF_ELEMS);
        collection = new TreeSet<>();
        cs.TEST("TreeSet", collection, MAX_AMOUNT_OF_ELEMS);


    }

}
