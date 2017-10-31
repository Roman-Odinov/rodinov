import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Конвертация двумерного массива в ArrayList и наоборот
 * Внутри методов использовать foreach.
 */
public class ConvertList {

    public static String printList(List<Integer> arrList) {
        StringBuilder sb = new StringBuilder();
        for (int l : arrList) {
            sb.append(l);
            sb.append("  ");
        }
        sb.append("\n");
        return sb.toString();
    }

    public static String printArray(int[][] arr) {
        return Arrays.deepToString(arr);
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
        Integer in;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (iter.hasNext()) {
                    in = iter.next();
                    if (in != null) {
                        arr[i][j] = in;
                    }
                } else {
                    arr[i][j] = 0;
                }
            }

        }

        return arr;
    }

    public static void main(String[] args) {

                        /* convert Array to ArrayList */

//        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7}};
//        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8}};
//        int[][] arr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10}};

        List<Integer> list = toList(arr);
        System.out.println("LIST print: \n" + printList(list));


                        /* convert ArrayList to 2D Array */

        ArrayList<Integer> list2 = new ArrayList<>(
                Arrays.asList(null, 2, null, 3, 4, 55, 66, null)
        );
        int[][] arr2 = toArray(list2, 4);

        System.out.println("2D ARRAY print: \n" + printArray(arr2));

    }

}
