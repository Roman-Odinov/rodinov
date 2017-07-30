package ru.job4j.max;

public class Max {

	private int result;

	public int max(int first, int second) {
		result = (first > second) ? first : second;
		return result;
	}
}