package ru.job4j.loop;

public class Board {
    /**
     * Нарисовать шахматную доску из символов x и пробелов.
     *
     * @param width  - это ширина доски
     * @param height - это высота доски
     * @return String
     */
    public String paint(int width, int height) {
        StringBuilder strb = new StringBuilder();
        final String LINE_BREAK = System.getProperty("line.separator");
        int counter = 1;    // общий счетчик положения курсора
        for (int rows = 1; rows <= height; rows++) {  // проходимся по строкам
            for (int columns = 1; columns <= width; columns++) {  // проходимся по столбцам
                // поочередно заполняем массив - Х если курсор на нечетной позичии, пробел - если на четной
                if (counter % 2 != 0) { // нечет
                    strb.append("x");
                } else {
                    strb.append(" ");
                }
                counter++;
            }
            // вставляем разрыв строки по окончанию строки
            strb.append(LINE_BREAK);
        }
        return strb.toString();     // конвертируем буфер StringBuilder-а в строку
    }

    /**
     * Протестируем как это выглядит на экране.
     */
    public static void main(String[] args) {
        Board board = new Board();
        System.out.print(board.paint(5, 3));
    }
}
