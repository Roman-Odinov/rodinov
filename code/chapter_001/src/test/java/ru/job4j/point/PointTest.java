package ru.job4j.point;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest {
	private int x = 5;
	private int y = 11;
	@Test
	public void correctnessCheck() {
		Point point = new Point(x, y);
		assertThat(point.equationCorrect(2, 1), is(true));
		assertThat(point.equationCorrect(3, 3), is(false));
	}
}