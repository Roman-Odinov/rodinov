import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Конвертация двумерного массива в ArrayList и наоборот
 * Внутри методов использовать foreach.
 */
public class ConvertList {

    // print List<Integer>
    public static void printList(List<Integer> arrList) {
        for (int l : arrList) {
            System.out.print(l + "  ");
        }
        System.out.println();
    }

    // print 2D array
    public static void printArr(int[][] arr) {
        System.out.println(Arrays.deepToString(arr));
    }

    /**
     * в метод приходит двумерный массив целых чисел,
     * необходимо пройтись по всем элементам массива и добавить их в List<Integer>.
     *
     * @param array
     * @return
     */
    public static List<Integer> toList(int[][] array) {

        ArrayList<Integer> arrList = new ArrayList<>();

        for (int[] arr2 : array) {
            for (int val : arr2) {
                arrList.add(val);
            }
        }
        return arrList;
    }

    /**
     * метод toArray должен равномерно разбить List на количество строк двумерного массива.
     * В методе toArray должна быть проверка - если количество элементов не кратно количеству строк -
     * оставшиеся значения в массиве заполнять нулями.
     *
     * Например в результате конвертации List со значениями (1,2,3,4,5,6,7) с разбиением на 3 строки
     * должен получиться двумерный массив {{1, 2, 3} {4, 5, 6} {7, 0 ,0}}
     *
     * @param list
     * @param rows
     * @return
     */
    public static int[][] toArray(List<Integer> list, int rows) {

        int[][] arr = new int[rows][rows];
        int listSize = list.size();
        if (listSize > (rows * rows)) {
            System.err.println("incompatible amout of elements");
            System.exit(-1);
        }

        Iterator<Integer> iter = list.iterator();

        // внешний по rows:
        for (int i = 0; i < rows; i++) {
            // внутренний по rows:
            for (int j = 0; j < rows; j++) {
                try {
                    // если итератор в норме добавляем итератор в текущую позицию массива
                    arr[i][j] = iter.next();
                    // если итератор не возвращает (Exception) - заполняем нулём
                } catch (Exception e) {
                    arr[i][j] = 0;
                }
            }

        }

        return arr;
    }

    public static void main(String[] args) {

//        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7}};
//        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8}};
//        int[][] arr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] arr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10} };

        List<Integer> list = toList(arr);
        printList(list);

        int[][] arr2 = toArray(list, 4);
        printArr(arr2);

    }

}
