package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void paint() throws Exception {
        final String LINE_BREAK = System.getProperty("line.separator");

        /**
         * Проверка доски 3 х 3
         */
        String expected = String.format("x x%s x %sx x%s", LINE_BREAK, LINE_BREAK, LINE_BREAK);
        Board board = new Board();
        String actual = board.paint(3, 3);
        assertEquals(expected, actual);

        /**
         * Проверка доски 5 х 4
         */
        expected = String.format("x x x%s x x %sx x x%s x x %s", LINE_BREAK, LINE_BREAK, LINE_BREAK, LINE_BREAK);
        actual = board.paint(5, 4);
        assertEquals(expected, actual);
    }

}