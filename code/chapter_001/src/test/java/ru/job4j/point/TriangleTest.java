package ru.job4j.point;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class TriangleTest {
	@Test
	public void whenAreaSetThreePointsThenTriangleArea() {
		Point a = new Point(0, 0);
		Point b = new Point(0, 2);
		Point c = new Point(2, 0);
		Triangle triangle = new Triangle(a, b, c);
		// Вычисляем площадь.
		double result = triangle.area();
		// Задаем ожидаемый результат.
		double expected = 2D;
		//Проверяем результат и ожидаемое значение.
		assertThat(result, closeTo(expected, 0.1));
  
		Point aa = new Point(6, 5);
		Point bb = new Point(6, 2);
		Point cc = new Point(2, 0);
		Triangle triangle2 = new Triangle(aa, bb, cc);
		// Вычисляем площадь.
		double result2 = triangle2.area();
		// Задаем ожидаемый результат.
		double expected2 = 6d;
		//Проверяем результат и ожидаемое значение.
		assertThat(result2, closeTo(expected2, 0.1));
	}
}