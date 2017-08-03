package ru.job4j.loop;

public class Paint {
    /**
     * Нарисовать пирамиду из символа ^ и пробелов.
     * @param h  - это высота пирамиды;
     * @return String.
     */
    public String pyramid(int h) {
        StringBuilder strb = new StringBuilder();
        final String LINE_BREAK = System.getProperty("line.separator");
        final String spaceChar = "\u0020";
        final String circumflexChar = "\u005e";
        // расчет ширины пирамиды исходя из h
        final int widthMax = 1 + 2 * (h - 1);
        int spacesCount, circumflexCount, widthCurr;
        String spaces, circumflex;
        // внешний цикл по строкам (h)
        for (int height = 1; height <= h; height++) {
            // расчет ширины текущей строки в галочках
            widthCurr = 1 + 2 * (height - 1);
            // расчет количества поробелов, необходимых с каждой стороны
            spacesCount = (widthMax - widthCurr) / 2;
            // расчет количества галочек
            circumflexCount = widthMax - spacesCount * 2;
            // пробелы
            spaces = new String(new char[spacesCount]).replace("\0", spaceChar);
            // галочки
            circumflex = new String(new char[circumflexCount]).replace("\0", circumflexChar);
            // заполнение текущей строки
            strb.append(spaces + circumflex + spaces);
            // вставляем разрыв строки по окончанию строки
            strb.append(LINE_BREAK);
        }
        // конвертируем буфер StringBuilder-а в строку
        return strb.toString();
    }

    /**
     * Протестируем как это выглядит на экране.
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        System.out.print(paint.pyramid(2));
    }
}


