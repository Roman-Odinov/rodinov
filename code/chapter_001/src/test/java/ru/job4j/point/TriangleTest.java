package ru.job4j.point;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));

        a = new Point(6, 5);
        b = new Point(6, 2);
        c = new Point(2, 0);
        triangle = new Triangle(a, b, c);
        result = triangle.area();
        expected = 6d;
        assertThat(result, closeTo(expected, 0.1));

        /**
         * треугольник построить невозможно - линии на одной прямой
         */
        a = new Point(1, 1);
        b = new Point(2, 2);
        c = new Point(3, 3);
        triangle = new Triangle(a, b, c);
        result = triangle.area();
        expected = 0;
        assertEquals(result, expected, 0);
    }
}