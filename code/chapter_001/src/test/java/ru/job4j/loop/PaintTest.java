package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaintTest {
    @Test
    public void pyramid() throws Exception {
        final String LINE_BREAK = System.getProperty("line.separator");
        Paint paint = new Paint();

        String actual = paint.pyramid(2);
        String expected = String.format(" ^ %s^^^%s", LINE_BREAK, LINE_BREAK);
        assertEquals(expected, actual);

        actual = paint.pyramid(3);
        expected = String.format("  ^  %s ^^^ %s^^^^^%s", LINE_BREAK, LINE_BREAK, LINE_BREAK);
        assertEquals(expected, actual);
    }

}